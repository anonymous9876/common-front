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
		autoConfcolumnsByPropertyPath['num'].render = formatMissionLink;
		var columnVersion = {
			"data":"version",
			"name":"version",
			"className":"property-path-version",
			"title":"<spring:message code="heros.version"></spring:message>",
			"orderable":false,
			"searchable":false,
			"visible":true,
			"render" : formatVersion
		};
		var columnHero = {
			"data":"hero",
			"name":"hero",
			"className":"property-path-hero",
			"title":"<spring:message code="heros.hero"></spring:message>",
			"orderable":false,
			"searchable":false,
			"visible":true,
			"render" : formatHero
		};
		replaceDataBaseAutoConfColumns(autoConfColumns, 'version.', columnVersion);
		replaceDataBaseAutoConfColumns(autoConfColumns, 'hero.', columnHero);
		//END change auto-conf  dataTable

		var tableElement = $('#paginated-table');
		var queryBuilderElement = $('#builder');

		<c:import url="querybuilder-config.js.jsp"></c:import>
		<c:import url="/WEB-INF/views/common/js/include/datatable-ajax.js.jsp"></c:import>

		var dataTableInit = function(){
			var dataTableConfig = {
				"language" : {
					"url" : languageUrl
				},
				"ajax" : ajaxJustAfterInitFactory(
					ajaxUrl,
					addQueryBuilderDataFactory($('#builder')),
					/**
					function callbackAlterData(data) {
						var queryBuilder = {
							"condition":"AND",
							"rules" : [],
							"valid":true
						};
						$('#form .rule').each(function(i, e) {
							var escapedPropertyPath = $(e).data('property-path').replace('.', '_');
							var type = $(e).data('type');
							var input = $(e).attr('type');
							if (!input) {
								input = 'text';
							}
							var operator = type === 'date' ? 'between' : 'contains';
							var valueLengthOk = operator == 'between' ? 2 : 1;
							var value = [];
							var toIsoDate = function(dateString) {
								var m = moment(dateString.trim(), 'L');
								return m.format('YYYY-MM-DD');
							};
							$('input', e).each(function(i, e) {
								var val = $(e).val();
								if (val != '') {
									if (type == 'date') {
										val = toIsoDate(val);
									}
									value.push(val);
								}
							})
							if (value.length == valueLengthOk) {
								if (value.length == 1) {
									value = value[0];
								}
								queryBuilder.rules.push(
									{
										"id": escapedPropertyPath,
										"field": escapedPropertyPath,
										"type": type,
										"input": input,
										"operator": operator,
										"value": value
									}
								)
							};
						});
						var queryBuilderIsEmpty = queryBuilder == null || queryBuilder.rules.length == 0;
						if (!queryBuilderIsEmpty) {
							data.queryBuilder = JSON.stringify(queryBuilder);
						}

						$('.no-rule').each(function(i, e){
							var val = $("input", e).val();
							var name = $(e).data('name');
							if (val != '') {
								data[name] = val;
							}
						})
					},
					**/
					tableElement,
					null//, hideTable, showTable
				),
				"processing" : true,
				"serverSide" : true,
				"deferRender" : true,
				"stateSave" : false,
				"stateDuration": 60 * 60 * 24,//one day
				"responsive" : true,
				"select": 'single',
				"keys" : false,
				"searching" : true,
				"dom" : 'rt<"row"<"col-xs-5"i><"col-xs-7"p>>',
				"iDisplayLength" : maxResult,
				"order": getOrder(),//[[ 0, 'asc' ]]
				"columns" : autoConfColumns
			};

			var table = tableElement.DataTable(dataTableConfig);
		};
		queryBuilderInit(dataTableInit);

		<c:import url="/WEB-INF/views/common/js/include/querybuilder-renders.js.jsp"></c:import>
		<c:import url="/WEB-INF/views/common/js/include/querybuilder-pluginbaseconfig.js.jsp"></c:import>
		<c:import url="/WEB-INF/views/common/js/include/form-autoconf.js.jsp"></c:import>
		formInsertInit(data, $('#form-post-container'));
		formPutInit(data, $('#form-put-container'));

		<c:import url="/WEB-INF/views/common/js/include/datatable-search.js.jsp"></c:import>
	};

	<c:import url="/WEB-INF/views/common/js/include/datatable-autoconf.js.jsp"></c:import>

	$.get(
		ajaxUrl + '?length=0',
		null,
		autoConfFactory(initDataTable)
	);
});
