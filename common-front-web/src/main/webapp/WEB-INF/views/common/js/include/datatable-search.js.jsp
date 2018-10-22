//begin datatable search
jQuery.fn.dataTableExt.oApi.fnSetFilteringEnterPress = function (oSettings) {
	var _that = this;
	this.each(function (i) {
		$.fn.dataTableExt.iApiIndex = i;
		var anControl = $('#datatable-search', _that.fnSettings().aanFeatures.f);

		anControl.unbind('keyup search input').bind('keyup search input', function (e) {
			if (anControl.val().length == "" || anControl.val().length > 2) {
				_that.fnFilter(anControl.val());
			}
		});
		return this;
	});
	return this;
};
tableElement.dataTable().fnSetFilteringEnterPress();
//end datatable search