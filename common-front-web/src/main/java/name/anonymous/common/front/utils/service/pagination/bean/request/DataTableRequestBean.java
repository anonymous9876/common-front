/**
 *
 */
package name.anonymous.common.front.utils.service.pagination.bean.request;

import java.util.ArrayList;
import java.util.List;

import name.anonymous.common.front.utils.service.pagination.bean.request.embded.DataTableColumnSpecs;
import name.anonymous.common.front.utils.service.pagination.bean.request.embded.DataTableOrder;
import name.anonymous.common.front.utils.service.pagination.bean.request.embded.DataTableSearch;

/**
 * Sent parameters by datatable library
 * see "Sent parameters" section of official datatables library :
 * https://datatables.net/manual/server-side
 * @author anonymous
 *
 */
public class DataTableRequestBean {
//	https://github.com/itfsw/QueryBuilder/blob/master/README-EN.md
//	private JsonRule queryBuilder;
	private String queryBuilder;

	private Integer draw;
	private Integer start;
	private Integer length;
	private DataTableSearch search;
	private List<DataTableColumnSpecs> columns = new ArrayList<>();
	private List<DataTableOrder> order = new ArrayList<>();

	/**
	 * @see name.anonymous.common.front.utils.service.pagination.bean.request.embded.DataTableSearch
	 * @return
	 */
	public DataTableSearch getSearch() {
		return search;
	}

	public void setSearch(DataTableSearch search) {
		this.search = search;
	}
	/**
	 * Draw counter. This is used by DataTables to ensure that the Ajax returns from server-side processing requests are drawn in sequence by DataTables (Ajax requests are asynchronous and thus can return out of sequence). This is used as part of the draw return parameter (see below).
	 * @return
	 */
	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	/**
	 * Paging first record indicator. This is the start point in the current data set (0 index based - i.e. 0 is the first record).
	 * @return
	 */
	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}
	/**
	 * Number of records that the table can display in the current draw. It is expected that the number of records returned will be equal to this number, unless the server has fewer records to return. Note that this can be -1 to indicate that all records should be returned (although that negates any benefits of server-side processing!)
	 * @return
	 */
	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
	/**
	 * @see name.anonymous.common.front.utils.service.pagination.bean.request.embded.DataTableColumnSpecs
	 * @return
	 */
	public List<DataTableColumnSpecs> getColumns() {
		return columns;
	}

	public void setColumns(List<DataTableColumnSpecs> columns) {
		this.columns = columns;
	}
	/**
	 * @see name.anonymous.common.front.utils.service.pagination.bean.request.embded.DataTableOrder
	 * @return
	 */
	public List<DataTableOrder> getOrder() {
		return order;
	}

	public void setOrder(List<DataTableOrder> order) {
		this.order = order;
	}

	/**
	 * No a official datatables field
	 * type is a String because Spring Default Message Converters for GET method don't handle Object property "value" than has list, map or a scalair value
	 * for deserialize and serialize this object, jackson must be used :
	 * <pre>
	 * {@code
	 * JsonRule jsonRule = objectMapper.readValue(getQueryBuilder(), new TypeReference<JsonRule>>(){});
	 * </pre>
	 *
	 * js Rule structure is described in the link below :
	 * https://querybuilder.js.org/api/Rule.html
	 *
	 * @return a json String of @see com.itfsw.query.builder.support.model.JsonRule
	 */
	public String getQueryBuilder() {
		return queryBuilder;
	}

	public void setQueryBuilder(String queryBuilder) {
		this.queryBuilder = queryBuilder;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataTableRequestBean [queryBuilder=").append(queryBuilder).append(", draw=").append(draw).append(", start=").append(start).append(", length=")
				.append(length).append(", search=").append(search).append(", columns=").append(columns).append(", order=").append(order).append("]");
		return builder.toString();
	}
}
