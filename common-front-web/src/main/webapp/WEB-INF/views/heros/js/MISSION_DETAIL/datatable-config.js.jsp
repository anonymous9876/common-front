<%@ page language="java" contentType="application/javascript; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="i18nJs" scope="request" class="name.anonymous.common.front.configuration.i18n.I18nJs"></jsp:useBean>
<jsp:useBean id="requestUtil" scope="request" class="name.anonymous.common.front.utils.request.RequestUtil"></jsp:useBean>

$(function() {
	var ajaxUrl = new URI(location.href.replace('.html', '.json')).search("");

	<c:import url="/WEB-INF/views/heros/js/include/datatable-renders.js.jsp"></c:import>
	var initDataTable = function(data, autoConfColumns, autoConfcolumnsByPropertyPath) {
		var languageUrl = data.languageUrl;
		var maxResult = data.maxResult;
		//BEGIN change auto-conf dataTable
		autoConfcolumnsByPropertyPath['dateLivAnnon'].render = formatDateLivAnnon;
		var columnDescription = {
			"data":"description",
			"name":"description",
			"className":"property-path-description",
			"title":"<spring:message code="heros.description"></spring:message>",
			"orderable":false,
			"searchable":false,
			"visible":true,
			"render" : formatProduct
		};
		var columnBuyer = {
			"data":"buyer",
			"name":"buyer",
			"className":"property-path-buyer",
			"title":"<spring:message code="heros.buyer"></spring:message>",
			"orderable":false,
			"searchable":false,
			"visible":true,
			"render" : formatBuyer
		};
		var columnDelivryAddress = {
			"data":"delivryAddress",
			"name":"delivryAddress",
			"className":"property-path-delivryAddress",
			"title":"<spring:message code="heros.delivryAddress"></spring:message>",
			"orderable":false,
			"searchable":false,
			"visible":true,
			"render" : formatAddress
		};
		replaceDataBaseAutoConfColumns(autoConfColumns, 'numArtFou', columnDescription);
		replaceDataBaseAutoConfColumns(autoConfColumns, 'delivryAddress.', columnDelivryAddress);
		replaceDataBaseAutoConfColumns(autoConfColumns, 'buyer.', columnBuyer);
		replaceDataBaseAutoConfColumns(autoConfColumns, 'descriptionArt');
		//END change auto-conf  dataTable

		var tableElement = $('#paginated-table');

		<c:import url="/WEB-INF/views/common/js/include/datatable-ajax.js.jsp"></c:import>

		var dataTableInit = function() {
			var dataTableConfig = {
				"language" : {
					"url" : languageUrl
				},
				"ajax" : ajaxJustAfterInitFactory(
					ajaxUrl,
					null,
					tableElement,
					data
				),
				"processing" : true,
				"serverSide" : true,
				"deferRender" : true,
				"stateSave" : false,
				"stateDuration": 60 * 60 * 24,//one day
				"responsive" : true,
				"searching" : true,
				"dom" : 'rt<"row"<"col-xs-5"i><"col-xs-7"p>>',
				"iDisplayLength" : maxResult,
				"order": getOrder(),//[[ 0, 'asc' ]]
				"columns" : autoConfColumns
			};

			var table = tableElement.DataTable(dataTableConfig);
		};
		dataTableInit();

		<c:import url="/WEB-INF/views/common/js/include/datatable-search.js.jsp"></c:import>
	}

	<c:import url="/WEB-INF/views/common/js/include/datatable-autoconf.js.jsp"></c:import>

	$.get(
		ajaxUrl + '?length=0',
		null,
		autoConfFactory(initDataTable)
	);
});
