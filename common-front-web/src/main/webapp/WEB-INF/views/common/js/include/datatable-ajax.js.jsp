//begin ajax factorty function
var addQueryBuilderDataFactory = function(queryBuilderSelector){
	var queryBuilderJqueryElement = $(queryBuilderSelector);
	return function (data) {
		var urlData = {};
		var queryBuilder = queryBuilderJqueryElement.queryBuilder('getRules');
		var queryBuilderIsEmpty = queryBuilder == null || queryBuilder.rules.length == 0;
		if (!queryBuilderIsEmpty) {
			data.queryBuilder = JSON.stringify(queryBuilder);
			urlData.queryBuilder = data.queryBuilder;
		}
		urlData.order = JSON.stringify(data.order);

		//update url
		window.history.pushState(null, null, new URI(location.href).query('').query(urlData).toString());
	}
};
var hideTable = function() {
	tableElement.parent('.dataTables_wrapper').hide();
};
var showTable = function() {
	if (!tableElement.is(":visible")) {
		tableElement.parent('.dataTables_wrapper').show();
	}
}

var ajaxJustAfterInitFactory = function(url, callbackAlterData, tableElement, callbackData) {
	return function (data, callback, settings) {
		if (callbackAlterData) {
			callbackAlterData(data);
		}
		$.get(url, data, callback);
	}
}

var notAjaxJustAfterInitFactory = function (url, callbackAlterData, tableElement, callbackData, callbackAjaxBeforeInit, callbackAjaxAfterInit) {
	var isAjaxInit = true;
	if (!callbackData) {
		var callbackData = {
			data:[],
			recordsFiltered : 0,
			recordsTotal : 0
		}
	}
	return function (data, callback, settings) {
		if (isAjaxInit) {
			if (callbackAjaxBeforeInit) {
				callbackAjaxBeforeInit();
			}
			isAjaxInit = false;
			callback(callbackData);
		} else {
			if (callbackAlterData) {
				callbackAlterData(data);
			}
			$.get(url, data, callback);

			if (callbackAjaxAfterInit) {
				callbackAjaxAfterInit();
			}
		}
	}
};
//end ajax factorty function