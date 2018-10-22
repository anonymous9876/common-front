/**
 * Select the bu and redirect to the home page of the application
 * 
 * @param code
 * @returns
 */
function selectBu(code) {
	var url = window.location.pathname;
	var urlSplit = url.split('/');
	var codeString = '' + code;
	while (codeString.length < 3) {
        codeString = '0' + codeString;
    }
    
	window.location.assign('/' + urlSplit[1] + '/' + codeString); 
}

/** date picker **/
$( document ).ready(function() {
	var userLang = navigator.languages[0];
	$('.date').datepicker({
		autoclose: true,
		language: userLang
	});
});