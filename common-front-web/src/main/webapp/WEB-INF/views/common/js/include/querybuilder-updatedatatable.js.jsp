<%@ page isELIgnored="true" %>
//begin updatedatatable
var queryBuilder = $('#builder');
var tableElement = $('#paginated-table');
var isRulesChangedInit = true;
queryBuilder.on('rulesChanged.queryBuilder  afterDeleteRule.queryBuilder afterDeleteGroup.queryBuilder', function (e) {
	if (isRulesChangedInit) {
		isRulesChangedInit = false;
	} else {
		if (queryBuilder.queryBuilder('validate')) {
			//update datatable
			var dataTableApi = tableElement.dataTable().api();
			dataTableApi.draw();
		}
	}
})
//end updatedatatable