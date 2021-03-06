package name.anonymous.common.front.app.heros.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import name.anonymous.common.front.app.heros.dto.table.ProductLineItemWebModel;
import name.anonymous.common.front.app.heros.model.ProductLineItemApiModel;
import name.anonymous.common.front.utils.request.RequestUtil;
import name.anonymous.common.front.utils.service.pagination.bean.api.PaginatedQueryParamService;
import name.anonymous.common.front.utils.service.pagination.bean.request.DataTableRequestBean;
import name.anonymous.common.front.utils.service.pagination.bean.response.PaginatedDataBean;

@Service
public class ProductLineItemService {
	@Autowired
	private RequestUtil requestUtil;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private RestTemplate rt;

	@Autowired
	private PaginatedQueryParamService paginatedQueryParamService;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	private String getBaseUrlController() {
		// financialReportingBean.getApiBaseUrl()
		return "http://localhost:8082" + "/api/business-units/{buCode}/{apiController}";/// heros/{hero}/
	}

	private ResponseEntity<String> paginatedDataJsonString(String apiController,
			DataTableRequestBean dataTableRequestBean) throws UnsupportedEncodingException {// String hero,
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(getBaseUrlController());
		String buCode = requestUtil.getBu();

		paginatedQueryParamService.setPaginatedQueryParam(dataTableRequestBean, uriComponentsBuilder);

		String restUrl = uriComponentsBuilder.buildAndExpand(buCode, apiController).toUriString();// , hero
		return rt.getForEntity(restUrl, String.class);
		// new ParameterizedTypeReference<List<Rate>>() {});
	}

	public PaginatedDataBean<ProductLineItemWebModel> listProductLineItemsPaginated(
			String idMission, DataTableRequestBean dataTableRequestBean) throws IOException {// String hero,
		PaginatedDataBean<ProductLineItemApiModel> listProductLineItemsPaginatedApi = listProductLineItemsPaginatedApi(
				idMission, dataTableRequestBean);// hero,
		PaginatedDataBean<ProductLineItemWebModel> paginatedDataBean = new PaginatedDataBean<>();

		dozerBeanMapper.map(listProductLineItemsPaginatedApi, paginatedDataBean);

		List<ProductLineItemWebModel> dataWeb = new ArrayList<>();
		for (ProductLineItemApiModel apiDto : listProductLineItemsPaginatedApi.getData()) {
			ProductLineItemWebModel productLineItemWebModel = dozerBeanMapper.map(apiDto,
					ProductLineItemWebModel.class);
			dataWeb.add(productLineItemWebModel);
		}
		paginatedDataBean.setData(dataWeb);
		return paginatedDataBean;
	}

	public PaginatedDataBean<ProductLineItemApiModel> listProductLineItemsPaginatedApi(
			String idMission, DataTableRequestBean dataTableRequestBean) throws IOException {// String heroSegment,
		Class<ProductLineItemApiModel> clazz = ProductLineItemApiModel.class;
		String jsonString = paginatedDataJsonString(
				"/missions/" + idMission + "/product-line-items", dataTableRequestBean).getBody();// heroSegment,
		return objectMapper.readValue(jsonString,
				objectMapper.getTypeFactory().constructParametricType(PaginatedDataBean.class, clazz));
	}

}
