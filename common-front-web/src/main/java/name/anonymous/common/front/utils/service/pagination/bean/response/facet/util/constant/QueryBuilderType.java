package name.anonymous.common.front.utils.service.pagination.bean.response.facet.util.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * QueryBuilder.types = {
    'string':   'string',
    'integer':  'number',
    'double':   'number',
    'date':     'datetime',
    'time':     'datetime',
    'datetime': 'datetime',
    'boolean':  'boolean'
};

	datatables types are very different :
	https://datatables.net/reference/option/columns.type
 *

 * @author anonymous
 *
 */
public enum QueryBuilderType {
	OBJECT, STRING, INTEGER, DOUBLE, BOOLEAN, DATETIME, DATE, TIME;

	@JsonCreator
	public static QueryBuilderType forValue(String value) {
		return QueryBuilderType.valueOf(value.toUpperCase());
	}

	@JsonValue
	public String toValue() {
		return this.toString().toLowerCase();
	}

}
