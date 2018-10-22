//begin autoConf querybuilder
var getQueryBuilderFilters = function(data, callbackAlterAutoConf){
	var propertyPaths = data.facet.table.propertyPaths;
	var filtersByPropertyPath = data.facet.table.filtersByPropertyPath;
	var queryBuilderFilters = [];
	var queryBuilderFiltersByPropertyPath = {};

	var defaultOperators = [ 'contains', 'not_contains', 'ends_with', 'not_ends_with', 'begins_with', 'not_begins_with', 'equal', 'not_equal' ];
	// 'is_empty', 'is_not_empty'
	// 'is_null', 'is_not_null'
	// 'less', 'less_or_equal', 'greater', 'greater_or_equal', 'between', 'not_between'

	var datePickerBaseConfig = getDatePickerBaseConfig();
	var selectBaseConfig = getSelectBaseConfig();
	var booleanBaseConfig = getBooleanBaseConfig();

	for (var i = 0; i < propertyPaths.length; i++) {
		var propertyPath = propertyPaths[i];
		var frontFilter = filtersByPropertyPath[propertyPath];
		if (frontFilter) {
			//var escapedPropertyPath = propertyPath.replace('.', '_');
			var queryBuilderFilter = {
				id : propertyPath,
				label : frontFilter.title,
				type : frontFilter.type,
				operators : defaultOperators,
			}
			switch (frontFilter.type) {
				case 'date' :
					$.extend(queryBuilderFilter, datePickerBaseConfig);
				break;
				case 'integer' :
				case 'double' :
					queryBuilderFilter.operators = ['between', 'not_between', 'greater_or_equal', 'greater', 'less_or_equal', 'less', 'equal', 'not_equal'];
				break;
				case 'boolean' :
					$.extend(queryBuilderFilter, booleanBaseConfig);
				break;
			}
			if (frontFilter.values) {
				$.extend(queryBuilderFilter, selectBaseConfig)
				queryBuilderFilter.values = frontFilter.values;
			}
			queryBuilderFilters.push(queryBuilderFilter);
			queryBuilderFiltersByPropertyPath[propertyPath] = queryBuilderFilter;
		} else {
			console.warn(propertyPath + ' has not filter');
		}
	}
	if (callbackAlterAutoConf) {
		return callbackAlterAutoConf(data, queryBuilderFilters, queryBuilderFiltersByPropertyPath)
	} else {
		return queryBuilderFilters;
	}
}
//end autoConf autoConf querybuilder
