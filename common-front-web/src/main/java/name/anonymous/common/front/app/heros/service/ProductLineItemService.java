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
		return "http://localhost:8082" + "/api/business-units/{buCode}/hero/{hero}/{apiController}";
	}

	private ResponseEntity<String> paginatedDataJsonString(String heroSegment, String apiController,
			DataTableRequestBean dataTableRequestBean) throws UnsupportedEncodingException {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(getBaseUrlController());
		String buCode = requestUtil.getBu();

		paginatedQueryParamService.setPaginatedQueryParam(dataTableRequestBean, uriComponentsBuilder);

		String restUrl = uriComponentsBuilder.buildAndExpand(buCode, heroSegment, apiController).toUriString();
		return rt.getForEntity(restUrl, String.class);
		// new ParameterizedTypeReference<List<Rate>>() {});
	}

	public PaginatedDataBean<ProductLineItemWebModel> listProductLineItemsPaginated(String heroSegment,
			String idMission, DataTableRequestBean dataTableRequestBean) throws IOException {
		PaginatedDataBean<ProductLineItemApiModel> listProductLineItemsPaginatedApi = listProductLineItemsPaginatedApi(
				heroSegment, idMission, dataTableRequestBean);
		PaginatedDataBean<ProductLineItemWebModel> paginatedDataBean = new PaginatedDataBean<>();

		dozerBeanMapper.map(listProductLineItemsPaginatedApi, paginatedDataBean);

		List<ProductLineItemWebModel> dataWeb = new ArrayList<>();
		for (ProductLineItemApiModel apiDto : listProductLineItemsPaginatedApi.getData()) {
			ProductLineItemWebModel ProductLineItemWebModel = dozerBeanMapper.map(apiDto,
					ProductLineItemWebModel.class);
			dataWeb.add(ProductLineItemWebModel);
		}
		paginatedDataBean.setData(dataWeb);
		return paginatedDataBean;

	}

	public PaginatedDataBean<ProductLineItemApiModel> listProductLineItemsPaginatedApi(String heroSegment,
			String idMission, DataTableRequestBean dataTableRequestBean) throws IOException {
		Class<ProductLineItemApiModel> clazz = ProductLineItemApiModel.class;
		String jsonString = paginatedDataJsonString(heroSegment,
				"/mission-indirect-headers/" + idMission + "/mission-indirect-details", dataTableRequestBean).getBody();
		return objectMapper.readValue(jsonString,
				objectMapper.getTypeFactory().constructParametricType(PaginatedDataBean.class, clazz));
	}

}
