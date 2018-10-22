$(function() {
	var formatDate = function (date, format, language) {
		return moment(date).format('L');
	};

	var parseDate = function (dateString, format, language) {
		return createDateAsUTC(getStringMoment(dateString).toDate());
	};

	$("#input-version-datCde-before, #input-version-datCde-after").datepicker({
		language : '<spring:url javaScriptEscape="true" value="${i18nJs.getDatePickerLocale()}" />',
		format : {
			toDisplay : formatDate,
			toValue : parseDate
		},
		todayBtn : 'linked',
		todayHighlight : true,
		autoclose : true
	});

	$('#form-submit').click(function(){
		var dataTableApi = $('#paginated-table').dataTable().api();
		dataTableApi.draw();
	});

	function get(object, key) {
		var properties = key.split('.');
		var value = object;
		for (var i = 0; i < properties.length; i++) {
			var property = properties[i];
			value = value[property];
		}
		return value;
	}

	function set(object, key, value) {
		var properties = key.split('.');
		var target = object;
		for (var i = 0; i < properties.length; i++) {
			var property = properties[i];
			var propertyValue = {};
			if (i == properties.length - 1) {
				propertyValue = value;
			}
			if (target[property] === undefined) {
				target[property] = propertyValue;
			}
			target = target[property];
		}
	}

	var toIsoDate = function(dateString) {
		var m = moment(dateString.trim(), 'L');
		return m.format('YYYY-MM-DD');
	};

	$('#put-button').click(function(){
		var updatedRow = $("#paginated-table").dataTable().api().rows({ selected: true });
		var updatedData = updatedRow.data()[0];
		var form = $('#form-put-container form');
		var hiddenIdInput = $('#id-put-id');
		hiddenIdInput.val(updatedData.id);
		var serializeArrayForm = form.serializeArray();
		for (var i = 0; i < serializeArrayForm.length; i++) {
			var name = serializeArrayForm[i].name;
			var input = $('[name="'+ name +'"]', form);
			var type = input.data('type');
			var displayValue = get(updatedData, name);
			switch (type) {
				case 'date' :
					displayValue = formatDate(displayValue);
				break;
			}
			input.val(displayValue);
		}
	});

	$('#put-submit').click(function(){
		var form = $('#form-put-container form');
		var array = form.serializeArray();
		var data = {};
		for (var i = 0; i < array.length; i++) {
			var entry = array[i];
			var input = $('[name="'+ entry.name + '"]', form);
			var sendValue = entry.value;
			var type = input.data('type');
			switch (type) {
				case 'date' :
					sendValue = toIsoDate(entry.value);
				break;
				case 'integer' :
				case 'double' :
					sendValue = parseInt(entry.value);
				break;
				case 'boolean' :
				break;
			}
			set(data, entry.name, sendValue);
		}
		var url = location.href.replace(".html", ".json");
		$.ajax({
			url : url,
			type: 'PUT',
			data: data,
			success : function(){
				$('#paginated-table').dataTable().api().draw();
			}
		});
	});

	var getFormData = function(formElement) {
		var array = formElement.serializeArray();
		var data = {};
		for (var i = 0; i < array.length; i++) {
			var entry = array[i];
			var input = $('[name="'+ entry.name + '"]', formElement);
			var sendValue = entry.value;
			var type = input.data('type');
			switch (type) {
				case 'date' :
					sendValue = toIsoDate(entry.value);
				break;
				case 'integer' :
				case 'double' :
					sendValue = parseInt(entry.value);
				break;
				case 'boolean' :
				break;
			}
			set(data, entry.name, sendValue);
		}
		return data;
	}
	$('#post-submit').click(function(){
		var form = $('#form-post-container form');
		var data = getFormData(form);
		var url = location.href.replace(".html", ".json");
		$.post(url, data, function(){
			$('#paginated-table').dataTable().api().draw();
		});
	});

	$('#patch-button').click(function(){
		var patchedRow = $("#paginated-table").dataTable().api().rows({ selected: true });
		var patchedData = patchedRow.data()[0];
		$('#id-patch-id').val(patchedData.id);
		$('#mntCde-patch-id').val(patchedData.mntCde);
	});

	$('#patch-submit').click(function(){
		var form = $('#form-patch-container form');
		var data = getFormData(form);
		var url = location.href.replace(".html", ".json");
		$.ajax({
			url : url,
			type: 'PATCH',
			data: data,
			success : function(){
				$('#paginated-table').dataTable().api().draw();
			}
		});
	});

	$('#delete-button').click(function(){
		var removedRow = $("#paginated-table").dataTable().api().rows({ selected: true });
		var removedData = removedRow.data()[0];
		var data = removedData.id;
		var url = location.href.replace(".html", ".json");
		$.ajax({
			url : url,
			type: 'DELETE',
			data: data,
			success : function(){
				$('#paginated-table').dataTable().api().draw();
//				removedRow.nodes()[0].remove();
//				removedRow.remove();
			}
		});
	});
})

