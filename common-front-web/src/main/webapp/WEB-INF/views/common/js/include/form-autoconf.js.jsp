//form-autoconfig
var formInsertInit = function(data, formElement) {
	var propertyPaths = data.facet.table.propertyPaths;
	var filtersByPropertyPath = data.facet.table.filtersByPropertyPath;

	var datePickerBaseConfig = getDatePickerBaseConfig();
	var selectBaseConfig = getSelectBaseConfig();
	var booleanBaseConfig = getBooleanBaseConfig();

	var form = $('<form/>');

	for (var i = 0; i < propertyPaths.length; i++) {
		var propertyPath = propertyPaths[i];
		var filter = filtersByPropertyPath[propertyPath];
		var fieldName = filter && filter.title ? filter.title : propertyPath;

		var id = propertyPath.replace('.', '-') + '-post-id';
		var formGroup = $('<div class="form-group">');
		var label = $('<label/>');
		label.attr('for', id);
		label.text(fieldName);

		var input = null;
		if (filter.values) {
			input = $('<select/>');
			for(value in filter.values) {
				var optionText = filter.values[value];
				var option = $('<option/>');
				option.attr('value', value);
				option.text(optionText);
				input.append(option);
			}
			input.append()
			input[selectBaseConfig.plugin](selectBaseConfig.plugin_config);
		} else {
			input = $('<input/>');
		}

		input.attr('id', id);
		input.attr('name', propertyPath);
		input.addClass('form-control');

		switch (filter.type) {
			case 'date' :
<!-- 				input.attr('type', 'date'); -->
				input[datePickerBaseConfig.plugin](datePickerBaseConfig.plugin_config);
			break;
			case 'integer' :
			case 'double' :
				input.attr('type', 'number');
			break;
			case 'boolean' :
				input.attr('type', 'checkbox');
			break;
		}
		input.data('type', filter.type);

		formGroup.append(label);
		formGroup.append(input);
		form.append(formGroup);

	}
	formElement.append(form);
};

var formPutInit = function(data, formElement) {
	var updatedRow = $("#paginated-table").dataTable().api().rows({ selected: true });
	var updatedData = updatedRow.data()[0];

	var propertyPaths = data.facet.table.propertyPaths;
	var filtersByPropertyPath = data.facet.table.filtersByPropertyPath;

	var datePickerBaseConfig = getDatePickerBaseConfig();
	var selectBaseConfig = getSelectBaseConfig();
	var booleanBaseConfig = getBooleanBaseConfig();

	var form = $('<form/>');
	var hiddenIdInput = $('<input type="hidden" name="id" id="id-put-id"/>');
	form.append(hiddenIdInput);

	for (var i = 0; i < propertyPaths.length; i++) {
		var propertyPath = propertyPaths[i];
		var filter = filtersByPropertyPath[propertyPath];
		var fieldName = filter && filter.title ? filter.title : propertyPath;

		var id = propertyPath.replace('.', '-') + '-put-id';
		var formGroup = $('<div class="form-group">');
		var label = $('<label/>');
		label.attr('for', id);
		label.text(fieldName);

		var input = null;
		if (filter.values) {
			input = $('<select/>');
			for(value in filter.values) {
				var optionText = filter.values[value];
				var option = $('<option/>');
				option.attr('value', value);
				option.text(optionText);
				input.append(option);
			}
			input.append()
			input[selectBaseConfig.plugin](selectBaseConfig.plugin_config);
		} else {
			input = $('<input/>');
		}

		input.attr('id', id);
		input.attr('name', propertyPath);
		input.addClass('form-control');

		switch (filter.type) {
			case 'date' :
<!-- 				input.attr('type', 'date'); -->
				input[datePickerBaseConfig.plugin](datePickerBaseConfig.plugin_config);
				$("#datepicker").datepicker("setDate", new Date());
			break;
			case 'integer' :
			case 'double' :
				input.attr('type', 'number');
			break;
			case 'boolean' :
				input.attr('type', 'checkbox');
			break;
		}
		input.data('type', filter.type);

		formGroup.append(label);
		formGroup.append(input);
		form.append(formGroup);
	}
	formElement.append(form);
};
//end form-insert-autoconfig