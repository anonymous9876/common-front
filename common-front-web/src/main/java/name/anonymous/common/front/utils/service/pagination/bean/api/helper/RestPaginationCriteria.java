package name.anonymous.common.front.utils.service.pagination.bean.api.helper;

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
