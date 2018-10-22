//begin updatedatatable
var queryBuilder = $('#builder-basic');
var tableElement = $('#paginated-table');
var isRulesChangedInit = true;
queryBuilder.on('rulesChanged.queryBuilder', function (e) {
	if (isRulesChangedInit) {
		isRulesChangedInit = false;
	} else {
		if (queryBuilder.queryBuilder('validate')) {
			var dataTableApi = tableElement.dataTable().api();
			dataTableApi.draw();
		}
	}
})
//end updatedatatable