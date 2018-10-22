<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> --%>

<jsp:useBean id="i18nJs" scope="request"
	class="name.anonymous.common.front.configuration.i18n.I18nJs"></jsp:useBean>
<jsp:useBean id="requestUtil" scope="request"
	class="name.anonymous.common.front.utils.request.RequestUtil"></jsp:useBean>

<!DOCTYPE html>
<html <c:import url="include/root-data.jsp"></c:import>>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message htmlEscape="true"
		code="${requestUtil.getApp()}.TITLE_${page}" /></title>
<c:import url="include/common-css.jsp"></c:import>
</head>
<body>
	<div class="app-wrapper currentBU_${requestUtil.getBuInt()}">
		<div>
			<c:import url="include/header.jsp"></c:import>
			<c:import url="include/nav.jsp"></c:import>
		</div>

		<main>
		<div id="container-main">
			<div>
				<div class="row">
					<div class="col-md-8">
						<h2 class="media-heading">
							<spring:message htmlEscape="true"
								code="${requestUtil.getApp()}.TITLE_${page}" />
						</h2>
					</div>
					<div class="col-md-4">
						<div class="pull-right">
							<c:import url="include/toolbar.jsp"></c:import>
						</div>
					</div>
				</div>
				<div class="row">
<!-- 					<div class="col-md-3"> -->
<%-- 						<c:import url="include/legal-supplier.jsp"></c:import> --%>
<!-- 					</div> -->
					<div class="id-payment col-md-9">
						<span> <span class="select-payment-label"><spring:message
									htmlEscape="true"
									code="${requestUtil.getApp()}.selectedOrderLabel" /></span><span>&nbsp;</span><span
							class="id-payment"><spring:escapeBody htmlEscape="true">${idMission}</spring:escapeBody></span>
						</span>
					</div>
				</div>


				<spring:message var="headerMessage" htmlEscape="false"
					code="${requestUtil.getApp()}.HEADER_${page}" />
				<c:if test="${not empty headerMessage}">
					<div class="bg-info">
						<i class="fas fa-info-circle"></i> ${headerMessage}
					</div>
				</c:if>
				<!-- 				<p class="bg-info"> -->
				<!-- 					<i class="fas fa-info-circle"></i> Press shift key and click a column to sort multiple columns at the same time -->
				<!-- 				</p> -->
			</div>
			<div id="builder-basic"></div>

			<div>
				<table id="paginated-table" class="table table-striped">
				</table>
			</div>

			<spring:message var="footerMessage" htmlEscape="false"
				code="${requestUtil.getApp()}.FOOTER_${page}" />
			<c:if test="${not empty footerMessage}">
				<div>
					<div class="bg-warning">
						<i class="fas fa-exclamation-triangle"></i> ${footerMessage}
					</div>
				</div>
			</c:if>
		</div>
		</main>

		<c:import url="include/common-js.jsp"></c:import>
		<script type="application/javascript"
			src="<spring:url htmlEscape="true" value="${requestUtil.getAppBaseUrl()}/${page}/datatable-config.js"/>"></script>
<c:import url="include/footer.jsp"></c:import>
	</div>
</body>
</html>