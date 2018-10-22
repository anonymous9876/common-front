<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<jsp:useBean id="requestUtil" scope="request"
	class="name.anonymous.common.front.utils.request.RequestUtil"></jsp:useBean>
lang=${pageContext.response.locale.language}
data-user-type=${requestUtil.getUserType()}
data-bu=${requestUtil.getBu()}
data-app=${requestUtil.getApp()}
