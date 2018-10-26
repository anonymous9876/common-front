//begin autoConf factorty function
var autoConfFactory = function(callbackForDataTableInit) {
	return function(data) {
		var propertyPaths = data.facet.table.propertyPaths;
		var filtersByPropertyPath = data.facet.table.filtersByPropertyPath;
		var columns = [];
		var columnsByPropertyPath = {};
		for (var i = 0; i < propertyPaths.length; i++) {
			var propertyPath = propertyPaths[i];
			var filter = filtersByPropertyPath[propertyPath];
			var column = {
				data : propertyPath,
				name : propertyPath,
				className : 'property-path-' + propertyPath.replace('.', '-'),
				title : filter && filter.title ? filter.title : propertyPath,
				orderable : true,
				searchable : true,
				visible : true
			}
			if (filter) {
				switch (filter.type) {
					case 'date' :
						column.render = formatDate;
					break;

					case 'integer' :
					case 'double' :
						column.render = formatNumberWithClass;
					break;
					case 'boolean' :
						column.render = formatBoolean;
					break;
				}
			}
			columns.push(column);
			columnsByPropertyPath[propertyPath] = column;

			if(filter && filter.values) {
				column.render = formatSelectFactory(filter.values);
			}
		}
		callbackForDataTableInit(data, columns, columnsByPropertyPath);
	}
};

var replaceDataBaseAutoConfColumns = function(columns, prefixColumnsToDelete, columnToAdd) {
	var startWith = function(i,e){return e.name.startsWith(prefixColumnsToDelete)};
	var notStartwith = function(i,e){return !startWith(i,e)};
	var toKeep = $(columns).filter(notStartwith);
	var toHide = $(columns).filter(startWith);
	toHide.each(function(i, e){ e.visible = false; });
	if (columnToAdd) {
		var firstRemoveElement = toHide.get(0);
		columns.splice($.inArray(firstRemoveElement, columns), 0, columnToAdd);
	}
}

var getOrder = function() {
	var orderArg = URI(location.href).search(true).order;
	if (!orderArg) {
		return [[0, 'asc']];
	}
	var order = JSON.parse(orderArg);
	return $.map(order, function(value, index){return [value.column, value.dir];});
}
//end autoConf factorty function
