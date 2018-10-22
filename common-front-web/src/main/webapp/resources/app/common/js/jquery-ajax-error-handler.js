$(function() {
	$(document).ajaxError(function(event, jqxhr, settings, thrownError) {
		console.error(event, jqxhr, settings, thrownError);
		if (jqxhr.status === 0 && jqxhr.state() === 'rejected') {
			console.warn('reload page after ajax redirect to cas');
			location.reload();
		}
	});
})
