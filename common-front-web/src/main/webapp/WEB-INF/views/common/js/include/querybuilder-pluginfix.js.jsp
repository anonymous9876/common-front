//begin pluginfix
var queryBuilder = $('#builder');

// Fix for Bootstrap Datepicker
	queryBuilder.on('afterUpdateRuleValue.queryBuilder', function (e, rule) {
		if (rule.filter.plugin === 'datepicker') {
			rule.$el.find('.rule-value-container input').datepicker('update')
		}
	})

// Fix for Bootstrap select
queryBuilder.on('afterDeleteGroup.queryBuilder', function () {
	$('.bootstrap-select').hide();
}).on('afterDeleteRule.queryBuilder', function () {
	$('.bootstrap-select').hide();
});

// Fix for Selectize
queryBuilder.on('afterCreateRuleInput.queryBuilder', function (e, rule) {
if (rule.filter.plugin == 'selectize') {
		rule.$el.find('.rule-value-container').css('min-width', '200px').find('.selectize-control').removeClass('form-control');
}
});
//end pluginfix