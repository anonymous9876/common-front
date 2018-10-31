package name.anonymous.common.front.utils.service.pagination.bean.api.helper;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Describe pagination parameters ready to send to a API
 * @author anonymous
 *
 */
public class RestPaginationCriteria {
	private Integer pageNumber;
	private Integer pageSize;
	private SortBy sortBy;

	/**
	 * @return page of API results, begin by 0
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 *
	 * @return number of lines by page results
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return order of API result properties
	 */
	public SortBy getSortBy() {
		return sortBy;
	}
	public void setSortBy(SortBy sortBy) {
		this.sortBy = sortBy;
	}

	public List<String> getSortByList() {
		List<String> sortBys = new ArrayList<>();
		for (Entry<String, SortOrder> entry : getSortBy().getSortBys().entrySet()) {
			sortBys.add(new StringBuilder().append(entry.getKey()).append(":").append(entry.getValue().toString()).toString());
		}
		return sortBys;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
