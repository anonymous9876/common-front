package name.anonymous.common.front.app.heros.service.delegate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;

import io.swagger.client.api.ProductLineItemByMissionControllerApi;
import io.swagger.client.model.PaginableRestResultProductLineItemDto;
import io.swagger.client.model.ProductLineItemDto;
import name.anonymous.common.front.app.heros.dto.table.ProductLineItemWebModel;
import name.anonymous.common.front.utils.request.RequestUtil;
import name.anonymous.common.front.utils.service.pagination.bean.api.helper.RestPaginationCriteria;
import name.anonymous.common.front.utils.service.pagination.bean.api.helper.RestPaginationCriteriaFactory;
import name.anonymous.common.front.utils.service.pagination.bean.request.DataTableRequestBean;
import name.anonymous.common.front.utils.service.pagination.bean.response.PaginatedDataBean;

public class ProductLineItemService {
	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private RequestUtil requestUtil;

	@Autowired
	private RestPaginationCriteriaFactory dataTablePaginationCriteriaFactory;

	private ProductLineItemByMissionControllerApi productLineItemByMissionControllerApi = new ProductLineItemByMissionControllerApi();

	public PaginableRestResultProductLineItemDto listProductLineItemPaginatedUsingGET(String buCode, String idMission, String filter, Integer limit,
			Integer offset, String search, List<String> sort) throws RestClientException {
		return productLineItemByMissionControllerApi.listProductLineItemPaginatedUsingGET(buCode, idMission, filter, limit, offset, search, sort);
	}

	public PaginatedDataBean<ProductLineItemWebModel> listProductLineItemsPaginated(
			String idMission, DataTableRequestBean dataTableRequestBean) throws IOException {// String hero,
		RestPaginationCriteria pagination = dataTablePaginationCriteriaFactory.getPaginationRequest(dataTableRequestBean);
		PaginableRestResultProductLineItemDto paginableRestResultProductLineItemDto = listProductLineItemPaginatedUsingGET(
				requestUtil.getBu(),
				idMission,
				dataTablePaginationCriteriaFactory.getFilterJson(dataTableRequestBean),
				dataTableRequestBean.getLength(),
				dataTableRequestBean.getStart(),
				dataTableRequestBean.getSearch().getValue(),
				pagination.getSortByList());// hero,

		PaginatedDataBean<ProductLineItemWebModel> paginatedDataBean = new PaginatedDataBean<>();

		dozerBeanMapper.map(paginableRestResultProductLineItemDto, paginatedDataBean);

		List<ProductLineItemWebModel> dataWeb = new ArrayList<>();
		for (ProductLineItemDto apiDto : paginableRestResultProductLineItemDto.getData()) {
			ProductLineItemWebModel productLineItemWebModel = dozerBeanMapper.map(apiDto,
					ProductLineItemWebModel.class);
			dataWeb.add(productLineItemWebModel);
		}
		paginatedDataBean.setData(dataWeb);
		return paginatedDataBean;
	}
}
