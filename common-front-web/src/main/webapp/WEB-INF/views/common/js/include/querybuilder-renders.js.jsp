var formatDate = function (date, format, language) {
	return moment(date).format('L');
};
var getStringMoment = function(dateString) {
	var alterDateString = dateString;
	if (typeof dateString === 'string') {
		alterDateString = dateString.trim();
	}
	return moment(alterDateString, 'L', true);
}

function createDateAsUTC(date) {
    return new Date(Date.UTC(date.getFullYear(), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds()));
}

function convertDateToUTC(date) {
    return new Date(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(), date.getUTCHours(), date.getUTCMinutes(), date.getUTCSeconds());
}

var parseDate = function (dateString, format, language) {
	return createDateAsUTC(getStringMoment(dateString).toDate());
}
var getIsoDate = function (rule) {
	var result = [];
	rule.$el.find('input').each(function (i, e) {
		var dateString = $(e).val();
		var m = moment(dateString.trim(), 'L');
		if (!m.isValid()) {
			return result;
		}
		result.push(m.format('YYYY-MM-DD'));
	});
	return result;
}
var setIsoDate = function (rule, value) {
	var dateString = rule.$el.find('input').each(function (i, e) {
		var v = jQuery.isArray(value) ? value[i] : value;
		var m = moment(v.trim(), 'YYYY-MM-DD');
		if (!m.isValid()) {
			return
		}
		var dateString = m.format('L');
		$(e).val(dateString);
	});
}
//end renders