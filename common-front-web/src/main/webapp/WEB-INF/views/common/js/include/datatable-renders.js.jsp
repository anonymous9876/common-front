<%@ page language="java" contentType="application/javascript; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
//renders
//begin baseRenders
//begin renders
var formatBoolean = function(data, type, row, meta) {
	if (data) {
		return '<i class="true fas fa-check"></i>';
	} else {
		return '<i class="false fas fa-times"></i>'
	}
};
var formatNumber = function (data, type, row, meta) {
	if (data === null) {return '';}
	return data.toLocaleString();
};
var formatDate = function (data, type, row, meta) {
	if (data === null) {return '';}
	return moment(new Date(data)).format("L");
};

var formatNumberWithClass = function(data, type, row, meta) {
	var container = $('<span/>');
	var numberFomrated = formatNumber(data);
	container.text(numberFomrated);
	if (data < 0) {
		container.addClass('negative-number');
	} else if (data > 0){
		container.addClass('positive-number');
	} else {
		container.addClass('null-number');
	}
	return container.get(0).outerHTML;
}

var formatSelectFactory = function(values) {
	return function(data, type, row, meta) {
		if (type === 'display') {
			return values[data] ? values[data] : data;
		} else {
			return data;
		}
	}
}
//end baseRenders
