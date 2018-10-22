package name.anonymous.common.front.utils.service.pagination.bean.response.facet.embed;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import name.anonymous.common.front.utils.service.pagination.bean.response.facet.util.constant.QueryBuilderType;

/**
 * Describe a property path for generate a default datatable and queryBuilder configuration
 * @author anonymous
 *
 */
public class DataTableFilter {
	private String title;

	private QueryBuilderType type;
	private Boolean orderable;
	private Boolean searchable;
	private Boolean visible;

	@JsonInclude(Include.NON_NULL)
	private Map<String, String> values;

	/**
	 * QueryBuilderType has two finalities :
	 * -  generate a filter form
	 * -  choose a render to display a value (HTML and Excel)
	 * @see name.anonymous.common.front.utils.service.pagination.bean.response.facet.util.constant.QueryBuilderType
	 */
	public QueryBuilderType getType() {
		return type;
	}

	public void setType(QueryBuilderType type) {
		this.type = type;
	}

	/**
	 * distinct code with their label of this column
	 */
	public Map<String, String> getValues() {
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}

	/**
	 * filter label and header cell label
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Boolean getOrderable() {
		return orderable;
	}

	/**
	 * Enable or disable ordering on this column
	 * @return
	 */
	public void setOrderable(Boolean orderable) {
		this.orderable = orderable;
	}

	public Boolean getSearchable() {
		return searchable;
	}

	/**
	 * Enable or disable filtering on the data in this column
	 * @return
	 */
	public void setSearchable(Boolean searchable) {
		this.searchable = searchable;
	}

	public Boolean getVisible() {
		return visible;
	}

	/**
	 * Enable or disable the display of this column
	 * @return
	 */
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
