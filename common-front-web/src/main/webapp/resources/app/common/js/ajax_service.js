var header = $("meta[name='_csrf_header']").attr("content");
var token = $("meta[name='_csrf']").attr("content");

/**
 * ajax call to the url with json data.
 * @param type
 * @param formData
 * @param url
 * @param onSuccess
 * @param onError
 */
function requestJsonAjax(type, formData, url, onSuccess, onError) {
	
	$.ajax({
		type : type,
		beforeSend : function(request) {
			request.setRequestHeader(header, token);
		},
		contentType : "application/json",
		url : url,
		data : JSON.stringify(formData),
		dataType : 'json',
		success : function(result) {
			onSuccess(result);
		},
		error : function(e) {
			onError(e);
		}
	}); 
}

/**
 * ajax call to the url without data.
 * @param type
 * @param url
 * @param onSuccess
 * @param onError
 */
function requestAjax(type, url, onSuccess, onError) {
	
	$.ajax({
		type : type,
		beforeSend : function(request) {
			request.setRequestHeader(header, token);
		},
		url : url,
		success : function(result) {
			onSuccess(result);
		},
		error : function(e) {
			onError(e);
		}
	}); 
}

/**
 * ajax call to send form to the url.
 * @param url
 * @param onSuccess
 * @param onError
 */
function postFormAjax(url, data, onSuccess, onError) {
	
	$.ajax({
	    type:"POST",
	    beforeSend : function(request) {
			request.setRequestHeader(header, token);
		},
	    data: data,
	    url: url,
	    async: false,
	    success : function(result) {
			onSuccess(result);
		},
		error : function(e) {
			onError(e);
		}
	});
}
