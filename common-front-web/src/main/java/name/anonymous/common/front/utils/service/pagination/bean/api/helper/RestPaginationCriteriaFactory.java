package name.anonymous.common.front.utils.service.pagination.bean.api.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import name.anonymous.common.front.utils.service.pagination.bean.request.DataTableRequestBean;
import name.anonymous.common.front.utils.service.pagination.bean.request.embded.DataTableColumnSpecs;
import name.anonymous.common.front.utils.service.pagination.bean.request.embded.DataTableOrder;

/**
 * Check datatable request and create a other pagination DTO.
 * if datatable request is empty, this DTO give first page of API results with ten lines
 * @author anonymous
 *
 */
@Service
public class RestPaginationCriteriaFactory {

	/**
	 * first page is 0
	 */
	private static final int DEFAULT_PAGE_NUMBER = 0;

	public RestPaginationCriteria getPaginationRequest(DataTableRequestBean dataTableRequestBean) {
		int pageNumber = DEFAULT_PAGE_NUMBER;
		if (dataTableRequestBean.getStart() != null && dataTableRequestBean.getStart() >= 0 && dataTableRequestBean.getLength() != null && dataTableRequestBean.getLength() > 0) {
			pageNumber = dataTableRequestBean.getStart() / dataTableRequestBean.getLength();
		}

		int pageSize = 10;
		if (dataTableRequestBean.getLength() != null) {
			pageSize = dataTableRequestBean.getLength();
		}

		RestPaginationCriteria restPaginationCriteria = new RestPaginationCriteria();

		restPaginationCriteria.setPageNumber(pageNumber);
		restPaginationCriteria.setPageSize(pageSize);

		SortBy sortBy = new SortBy();
		for (DataTableOrder dataTableOrder : dataTableRequestBean.getOrder()) {
			DataTableColumnSpecs column = dataTableRequestBean.getColumns().get(dataTableOrder.getColumn());
			String propertieName = column.getData();
			sortBy.addSort(propertieName, SortOrder.valueOf(dataTableOrder.getDir().toUpperCase()));
		}
		restPaginationCriteria.setSortBy(sortBy);

		return restPaginationCriteria;
	}

	public String getFilterJson(DataTableRequestBean dataTableRequestBean) throws UnsupportedEncodingException {
		return URLEncoder.encode(dataTableRequestBean.getQueryBuilder(), StandardCharsets.UTF_8.toString());
	}
}
