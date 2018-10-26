<%@ page language="java" contentType="application/javascript; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/views/common/js/include/datatable-renders.js.jsp"></c:import>

var formatMissionLink = function(data, type, row, meta) {
	var a = $('<a/>');
	a.text(data);
	var urlWithoutIdMission = '<spring:url javaScriptEscape="true" value="mission-{idMission}-detail.html" />';
	var url = urlWithoutIdMission.replace('{idMission}', row.id);
	a.attr('href', url);
	return a.get(0).outerHTML;
}

var formatDateLivAnnon = function(data, type, row, meta) {
	var dateLivAnnon = formatDate(data);
	var container = $('<span></span>');
	container.text(dateLivAnnon);
	if (row.dateLivSouh != data) {
		container.addClass('not-equals-with-dateLivSouh');
	}
	return container.get(0).outerHTML;
}

var formatProduct = function ( data, type, row, meta ) {
	var product = row.product;
	var text = product.numArtFou + ' - ' + product.descriptionArt;
	return text;
}

var formatVersion = function ( data, type, row, meta ) {
	var version = row.version;
	if (!version) {
		return '';
	}
	return version.num + '-' + formatDate(version.date);
}

var formatHero = function ( data, type, row, meta ) {
	var hero = row.hero;
	if (!hero) {
		return '';
	}
	return hero.num + ' - ' + hero.name;
}

var formatBuyer = function ( data, type, row, meta ) {
	var buyer = row.buyer;
	var link = $('<a/>');
	var text = buyer.firstName + ' ' + buyer.lastName;
	link.text(text);
	link.attr('href', 'mailto:' + buyer.email);
	return link.get(0).outerHTML;
}

var formatAddress = function ( data, type, row, meta ) {
	var delivryAddress = row.delivryAddress;
	var text = delivryAddress.adrLibAdr001 + ' ' + delivryAddress.adrLibVil;
	var container = $('<span></span>');
	container.text(text);
	container.attr('title', delivryAddress.adrLibAdr001 + ' ' + delivryAddress.adrLibAdr002 + ' '  + delivryAddress.adrLibAdr003 + ' ' + delivryAddress.adrCodPst + ' ' + delivryAddress.adrLibVil + ' ' + delivryAddress.adrNumPay);
	return container.get(0).outerHTML;
}