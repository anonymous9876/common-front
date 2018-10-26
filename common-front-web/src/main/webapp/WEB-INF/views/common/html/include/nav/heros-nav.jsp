<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="requestUtil" scope="request" class="name.anonymous.common.front.utils.request.RequestUtil"></jsp:useBean>

<c:set scope="page" var="appName" value="heros"></c:set>
<c:set scope="page" var="appIsActive" value="${requestUtil.getApp() eq appName}"></c:set>
<c:set scope="page" var="baseUrl" value="${requestUtil.getBuBaseUrl()}/${appName}"></c:set>

<ul class="nav navbar-nav">
	<li
		class="dropdown <c:if test="${appIsActive}">active</c:if>"><a
		href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
		aria-haspopup="true" aria-expanded="false"><spring:message
						htmlEscape="false" code="heros.appName" /><span
			class="caret"></span>
	</a>
		<ul class="dropdown-menu">
			<li
				class="tabElement <c:if test="${appIsActive and page eq 'ORDERS'}">activeGlobalTab</c:if>"><a
				href="<spring:url htmlEscape="true" value="${baseUrl}/missions.html"/>"><spring:message
						htmlEscape="false" code="heros.TITLE_ORDERS" /></a></li>
		</ul>
</ul>