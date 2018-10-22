<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<jsp:useBean id="i18nJs" scope="request"
	class="name.anonymous.common.front.configuration.i18n.I18nJs"></jsp:useBean>

<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/lib/jquery/jquery.js"/>"></script>
<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/app/common/js/jquery-ajax-error-handler.js"/>"></script>
<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/app/common/js/jquery-param-fix-for-spring.js"/>"></script>
<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/lib/DataTables/datatables.js"/>"></script>
<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/lib/bootstrap/js/bootstrap.js"/>"></script>
<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/lib/jQuery.extendext/jQuery.extendext.js"/>"></script>
<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/lib/doT/doT.js"/>"></script>

<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/lib/moment/moment.js"/>"></script>
<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="${i18nJs.getMoment()}"/>"></script>
<script type="application/javascript">moment.locale('${i18nJs.getMomentLocale()}')</script>

<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/lib/QueryBuilder/js/query-builder.js"/>"></script>
<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="${i18nJs.getQueryBuilder()}" />"></script>

<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/lib/bootstrap-datepicker/js/bootstrap-datepicker.js"/>"></script>
<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="${i18nJs.getDatePicker()}" />"></script>

<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/lib/bootstrap-select/js/bootstrap-select.js"/>"></script>
<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="${i18nJs.getSelect()}" />"></script>
<%-- <script type="application/javascript" src="<spring:url htmlEscape="true" value="/resources/lib/bootstrap-switch/js/bootstrap-switch.js"/>"></script> --%>

<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/lib/bootstrap-float-label/bootstrap-float-label.js" />"></script>
<script type="text/javascript">
$(function(){
	$.bootstrapFloatLabel();
})
</script>
<script type="application/javascript"
	src="<spring:url htmlEscape="true" value="/resources/app/common/js/btn-export-excel.js"/>"></script>