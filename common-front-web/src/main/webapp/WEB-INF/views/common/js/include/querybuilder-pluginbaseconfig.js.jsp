<%@ page language="java" contentType="application/javascript; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:useBean id="i18nJs" scope="request" class="name.anonymous.common.front.configuration.i18n.I18nJs"></jsp:useBean>

//begin pluginbaseconfig
var getBooleanBaseConfig = function() {
	return {
		type : 'string',
		operators : [ 'equal', 'not_equal' ],
		input : 'select',
		values : {
			true : '✓',
			false : '⨯'
		},
		plugin : 'selectpicker',
		plugin_config : {
			container : 'body'
		}
	};
};
var getDatePickerBaseConfig = function() {
	return {
		type : 'date',
		validation : {
			format: 'YYYY-MM-DD'
		},
		operators : [ 'between', 'not_between', 'greater_or_equal', 'greater', 'less_or_equal', 'less', 'equal', 'not_equal' ],
		valueGetter : getIsoDate,
		valueSetter : setIsoDate,
		plugin : 'datepicker',
		plugin_config : {
			language : '<spring:url javaScriptEscape="true" value="${i18nJs.getDatePickerLocale()}" />',
			format : {
				toDisplay : formatDate,
				toValue : parseDate
			},
			todayBtn : 'linked',
			todayHighlight : true,
			autoclose : true
		}
	};
};

var getSelectBaseConfig = function() {
	return {
		operators : [ 'in', 'not_in' ],
		input : 'select',
		multiple : true,
		plugin : 'selectpicker',
		plugin_config : {
			container : 'body'
		}
	};
}
//end pluginbaseconfig