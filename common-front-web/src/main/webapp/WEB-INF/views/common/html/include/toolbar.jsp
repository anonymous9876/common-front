<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<div class="form-inline">
		<div class="form-group">
			<label class="sr-only" for="datatable-search"><spring:message
					htmlEscape="true" code="common.global-search"></spring:message></label>
			<div class="input-group">
				<div class="input-group-addon">
					<i class="fas fa-search"></i>
				</div>
				<input id="datatable-search" type="search" class="form-control"
					placeholder="<spring:message htmlEscape="true" code="common.global-search"></spring:message>">
			</div>
		</div>

		<div class="form-group">
			<a id="btn-export-excel-unique" class="btn btn-default" role="button"
				href="#" download> <i class="far fa-file-excel"></i>
			</a>
		</div>

		<div id="datatable-filter" class="form-group">
			<button class="btn btn-default" type="button">
				<i class="fas fa-filter"></i>
			</button>
		</div>
	</form>
</div>