var btnExportExcel = function (exportButtonSelector, href, dataTableSelector, queryBuilderSelector) {
	if (!exportButtonSelector) {
		var exportButtonSelector = $("#btn-export-excel-unique");
	}
	if (!href) {
		var href = location.href.replace(".html", ".xlsx");
	}
	if (!dataTableSelector) {
		var dataTableSelector = $("#paginated-table");
	}

	var getQueryParameters = function() {
		var queryParamaters = {};
		if (dataTableSelector.length > 0) {
			var dataTableApi = dataTableSelector.dataTable().api();
			var params = dataTableApi.ajax.params();
			queryParamaters = params;
		} else {
			console.warn('dataTableSelector is empty, excel export button has not his filter');
		}
		return queryParamaters;
	}

	//fallback if URL.createObjectURL don't exist
	$(dataTableSelector).on('xhr.dt', function(e, settings, json, xhr){
		var dataTableApi = dataTableSelector.dataTable().api();
		var params = dataTableApi.ajax.params();
		$(exportButtonSelector).attr("href", href + "?" + jQuery.param(params, false));
	})
	if (URL.createObjectURL) {
		//disable button during the download
		var downloadAfterClick = function (event) {
			event.preventDefault();
			$(exportButtonSelector).off();
			$(exportButtonSelector).addClass("disabled");

			var xhr = new XMLHttpRequest();
			xhr.open('GET', href + "?" + jQuery.param(getQueryParameters(), false), true);
			xhr.responseType = 'blob';
			xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
			xhr.onload = function(e) {
				if (this.status == 200) {
					var blob = new Blob([ this.response ]);
					var downloadUrl = URL.createObjectURL(blob);
					var a = document.createElement("a");
					a.href = downloadUrl;

					var filename = "";
					var disposition = xhr.getResponseHeader('Content-Disposition');
					if (disposition && disposition.indexOf('attachment') !== -1) {
						var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
						var matches = filenameRegex.exec(disposition);
						if (matches != null && matches[1]) {
							filename = matches[1].replace(/['"]/g, '');
						}
					}

					a.download = filename;
					document.body.appendChild(a);
					a.click();
					$(exportButtonSelector).removeClass("disabled");
					$(exportButtonSelector).click(downloadAfterClick);
					a.remove();
				} else {
					console.error("status != 200", e);
					$(exportButtonSelector).removeClass("disabled");
					$(exportButtonSelector).addClass("btn-warning");
				}
			};
			xhr.onerror = function(e) {
				console.error("error", e);
				$(exportButtonSelector).removeClass("disabled");
				$(exportButtonSelector).addClass("btn-warning");
			}

			xhr.onabort = function(e) {
				console.error("abort", e);
				$(exportButtonSelector).removeClass("disabled");
				$(exportButtonSelector).addClass("btn-warning");
			}

			xhr.ontimeout = function(e) {
				console.error("timeout", e);
				$(exportButtonSelector).removeClass("disabled");
				$(exportButtonSelector).addClass("btn-warning");
			}

			xhr.send();
		}
		$(exportButtonSelector).off().click(downloadAfterClick);
	}
}

$(function () {
	btnExportExcel();
})