//begin validators

/**
$.extend($.expr[':'], {
	emptyVal : function (el) {
		return $(el).val() === "";
	}
});

var notEmpties = function (value, rule) {
	return rule.$el.find('.rule-value-container :input:emptyVal:first').length == 0
}

var validDates = function(value, rule) {
	var valid = true;
	rule.$el.find('.rule-value-container :input').each(function(i, el){
		if (!getStringMoment($(el).val()).isValid()) {
			if ($(el).val() === '') {
				valid = [$.fn.queryBuilder.regional[queryBuilderLangCode].errors.string_empty, $(el).val()];
			} else {
				valid = ['{0} is not a valid date', $(el).val()];
			}
		}
	})
	return valid;
}
**/

//end validators