<%@ page language="java" contentType="application/javascript; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="i18nJs" scope="request" class="name.anonymous.common.front.configuration.i18n.I18nJs"></jsp:useBean>
<jsp:useBean id="requestUtil" scope="request" class="name.anonymous.common.front.utils.request.RequestUtil"></jsp:useBean>

//BEGIN querybuilder-config
var queryBuilderInit = function(callback){
	var queryBuilderLangCode = '<spring:escapeBody javaScriptEscape="true">${i18nJs.getQueryBuilderLocale()}</spring:escapeBody>';
	<c:import url="/WEB-INF/views/common/js/include/querybuilder-renders.js.jsp"></c:import>
	<c:import url="/WEB-INF/views/common/js/include/querybuilder-validators.js.jsp"></c:import>
	<c:import url="/WEB-INF/views/common/js/include/querybuilder-pluginfix.js.jsp"></c:import>
	<c:import url="/WEB-INF/views/common/js/include/querybuilder-updatedatatable.js.jsp"></c:import>
	<c:import url="/WEB-INF/views/common/js/include/querybuilder-pluginbaseconfig.js.jsp"></c:import>

	<c:import url="/WEB-INF/views/common/js/include/querybuilder-autoconf.js.jsp"></c:import>
	var filters = getQueryBuilderFilters(data);//add calback arg for alter filters
	var queryBuilderConfig = {
		plugins : [ 'bt-tooltip-errors' ],
		lang_code : queryBuilderLangCode,
		allow_empty : true,
		filters : filters
	};
	queryBuilderElement.queryBuilder(queryBuilderConfig);
	callback();
}
//END querybuilder-config
