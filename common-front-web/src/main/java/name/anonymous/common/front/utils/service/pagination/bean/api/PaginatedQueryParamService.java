package name.anonymous.common.front.utils.service.pagination.bean.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import name.anonymous.common.front.utils.service.pagination.bean.api.helper.RestPaginationCriteria;
import name.anonymous.common.front.utils.service.pagination.bean.api.helper.RestPaginationCriteriaFactory;
import name.anonymous.common.front.utils.service.pagination.bean.api.helper.SortOrder;
import name.anonymous.common.front.utils.service.pagination.bean.request.DataTableRequestBean;

/**
 * Pass pagination parametters (offset, limit, search, filter) in a URL if GET method is used
 * @author anonymous
 *
 */
@Service
public class PaginatedQueryParamService {
	@Autowired
	private RestPaginationCriteriaFactory dataTablePaginationCriteriaFactory;

	public void setPaginatedQueryParam(DataTableRequestBean dataTableRequestBean, UriComponentsBuilder uriComponentsBuilder) throws UnsupportedEncodingException {
		RestPaginationCriteria pagination = dataTablePaginationCriteriaFactory.getPaginationRequest(dataTableRequestBean);
		ArrayList<String> sortBys = new ArrayList<>();
		for (Entry<String, SortOrder> entry : pagination.getSortBy().getSortBys().entrySet()) {
			sortBys.add(new StringBuilder().append(entry.getKey()).append(":").append(entry.getValue().toString()).toString());
		}
		uriComponentsBuilder.queryParam("offset", pagination.getPageSize() * pagination.getPageNumber());
		uriComponentsBuilder.queryParam("limit", pagination.getPageSize());
		if (!sortBys.isEmpty()) {
			uriComponentsBuilder.queryParam("sort", String.join(",", sortBys));
		}

		if (dataTableRequestBean.getSearch() != null && dataTableRequestBean.getSearch().getValue() != null && dataTableRequestBean.getSearch().getValue().length() >= 1) {
			uriComponentsBuilder.queryParam("search", dataTableRequestBean.getSearch().getValue());
		}

		if (dataTableRequestBean.getQueryBuilder() != null) {
			uriComponentsBuilder.queryParam("filter", URLEncoder.encode(dataTableRequestBean.getQueryBuilder(), StandardCharsets.UTF_8.toString()));
		}
	}
}
