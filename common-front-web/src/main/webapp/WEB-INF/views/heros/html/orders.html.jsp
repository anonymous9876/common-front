<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> --%>

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
					<div class="col-sm-6">
						<h2 class="media-heading">
							<spring:message htmlEscape="true"
								code="${requestUtil.getApp()}.TITLE_${page}" />
						</h2>
					</div>
					<div class="col-sm-6">
						<div class="pull-right">
							<c:import url="include/toolbar.jsp"></c:import>
						</div>
					</div>
				</div>

				<spring:message var="headerMessage" htmlEscape="false"
					code="${requestUtil.getApp()}.HEADER_${page}" />
				<c:if test="${not empty headerMessage}">
					<div class="bg-info">
						<i class="fas fa-info-circle"></i> ${headerMessage}
					</div>
				</c:if>
			</div>

			<div id="builder-basic"></div>

			<div>
				<!-- 				<form id="form"> -->
				<!-- 					<div class="row"> -->
				<!-- 						<div class="col-md-5"> -->
				<!-- 							<div class="rule form-group float-label" -->
				<!-- 								data-property-path="hero.nomFour" data-type="string"> -->
				<%-- 								<label for="input-nomFour"><spring:message --%>
				<%-- 										htmlEscape="true" --%>
				<%-- 										code="${requestUtil.getApp()}.hero.nomFour" /></label> <input --%>
				<!-- 									id="input-nomFour" type="text" class="form-control" -->
				<%-- 									placeholder="<spring:message htmlEscape="true" --%>
				<%-- 						code="${requestUtil.getApp()}.hero.nomFour" />" /> --%>
				<!-- 							</div> -->

				<!-- 							<div class="no-rule form-group float-label" -->
				<!-- 								data-name="commandePar"> -->
				<%-- 								<label for="input-commandePar"><spring:message --%>
				<%-- 										htmlEscape="true" code="${requestUtil.getApp()}.buyer" /></label> <input --%>
				<!-- 									id="input-commandePar" type="text" class="form-control" -->
				<%-- 									placeholder="<spring:message htmlEscape="true" --%>
				<%-- 						code="${requestUtil.getApp()}.buyer" />" /> --%>
				<!-- 							</div> -->
				<!-- 						</div> -->
				<!-- 						<div class="col-md-5"> -->
				<!-- 							<div class="rule" data-property-path="version.datCde" -->
				<!-- 								data-type="date"> -->

				<!-- 								<div class="row"> -->
				<%-- 									<label for="input-version-datCde-before" class="col-md-4"><spring:message --%>
				<%-- 										htmlEscape="true" --%>
				<%-- 										code="${requestUtil.getApp()}.version.datCde" /></label> --%>

				<!-- 									<div class="col-md-4 form-group float-label"> -->
				<!-- 										<input id="input-version-datCde-before" type="text" -->
				<!-- 											class="form-control" placeholder="après" /> -->
				<!-- 									</div> -->
				<!-- 									<div class="col-md-4 form-group float-label"> -->
				<!-- 										<input id="input-version-datCde-after" type="text" -->
				<!-- 											class="form-control" placeholder="avant" /> -->
				<!-- 									</div> -->


				<!-- 								</div> -->
				<!-- 							</div> -->

				<!-- 							<div class="rule form-group float-label" -->
				<!-- 								data-property-path="num" data-type="string"> -->
				<%-- 								<label for="input-num"><spring:message --%>
				<%-- 										htmlEscape="true" code="${requestUtil.getApp()}.num" /> </label> <input --%>
				<!-- 									id="input-num" type="text" class="form-control" -->
				<%-- 									placeholder="<spring:message htmlEscape="true" --%>
				<%-- 						code="${requestUtil.getApp()}.num" />" /> --%>
				<!-- 							</div> -->
				<!-- 						</div> -->

				<!-- 						<div class="col-md-2"> -->
				<!-- 							<button id="form-submit" type="button" class="btn btn-primary">OK</button> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 				</form> -->


				<table id="paginated-table" class="table table-striped">
				</table>

				<div id="alter-data-form">
					<button id="post-button" type="button"
						class="btn btn-default btn-success" data-toggle="modal"
						data-target="#modal-post">post</button>
					<button id="put-button" type="button"
						class="btn btn-default btn-warning" data-toggle="modal"
						data-target="#modal-put">put</button>
					<button id="patch-button" type="button"
						class="btn btn-default btn-warning" data-toggle="modal"
						data-target="#modal-patch">patch</button>
					<button id="delete-button" type="button"
						class="btn btn-default btn-danger">delete</button>
				</div>


				<div class="modal fade" id="modal-post" tabindex="-1" role="dialog"
					aria-labelledby="modal-post-label" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="modal-post-label">Modal title</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>

							<div id="form-post-container" class="modal-body"></div>

							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button id="post-submit" type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
					</div>
				</div>

				<div class="modal fade" id="modal-put" tabindex="-1" role="dialog"
					aria-labelledby="modal-put-label" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="modal-put-label">Modal title</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>

							<div id="form-put-container" class="modal-body"></div>

							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button id="put-submit" type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
					</div>
				</div>

				<div class="modal fade" id="modal-patch" tabindex="-1" role="dialog"
					aria-labelledby="modal-patch-label" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="modal-patch-label">Modal title</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>

							<div id="form-patch-container" class="modal-body">
								<form>
									<input id="id-patch-id" name="id" type="hidden">
									<div class="form-group">
										<label for="mntCde-put-id">Montant</label><input
											id="mntCde-patch-id" name="mntCde" class="form-control"
											type="number">
									</div>
								</form>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button id="patch-submit" type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
					</div>
				</div>
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
		<script type="application/javascript"
			src="<spring:url htmlEscape="true" value="/resources/app/heros/js/orders.js"/>"></script>
		<c:import url="include/footer.jsp"></c:import>
	</div>
</body>
</html>