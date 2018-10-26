package name.anonymous.common.front.app.heros.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import name.anonymous.common.front.app.heros.dto.table.MissionTableModel;
import name.anonymous.common.front.app.heros.model.MissionApiModel;
import name.anonymous.common.front.utils.request.RequestUtil;
import name.anonymous.common.front.utils.service.pagination.bean.api.PaginatedQueryParamService;
import name.anonymous.common.front.utils.service.pagination.bean.request.DataTableRequestBean;
import name.anonymous.common.front.utils.service.pagination.bean.response.PaginatedDataBean;

@Service
public class MissionService {
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

	private static final String BASE_URL = "http://localhost:8082" + "/api/business-units/{buCode}";

	private String getBaseUrlControllerByBU() {
		return BASE_URL + "/{apiController}";
	}

	private String getBaseUrlControllerByBUWithId() {
		return BASE_URL + "/{apiController}/{id}";
	}

	private String getBaseUrlControllerByhero() {
		return BASE_URL + "/heros/{hero}/{apiController}";
	}

	private ResponseEntity<String> get(String heroSegment, String apiController) {
		UriComponentsBuilder restUrlBuilder = UriComponentsBuilder.fromUriString(getBaseUrlControllerByhero());
		String buCode = requestUtil.getBu();
		String restUrl = restUrlBuilder.buildAndExpand(buCode, heroSegment, apiController).toUriString();
		return rt.getForEntity(restUrl, String.class);
	}

	private ResponseEntity<String> getPaginated(String heroSegment, String apiController,
			DataTableRequestBean dataTableRequestBean) throws UnsupportedEncodingException {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(getBaseUrlControllerByhero());
		String buCode = requestUtil.getBu();

		paginatedQueryParamService.setPaginatedQueryParam(dataTableRequestBean, uriComponentsBuilder);

		String restUrl = uriComponentsBuilder.buildAndExpand(buCode, heroSegment, apiController).toUriString();
		return rt.getForEntity(restUrl, String.class);
		// new ParameterizedTypeReference<List<Rate>>() {});
	}

	private ResponseEntity<String> post(String heroSegment, String apiController, Object data) {
		UriComponentsBuilder restUrlBuilder = UriComponentsBuilder.fromUriString(getBaseUrlControllerByBU());
		String buCode = requestUtil.getBu();
		String restUrl = restUrlBuilder.buildAndExpand(buCode, apiController).toUriString();
		return rt.postForEntity(restUrl, data, String.class);
	}

	private void put(String apiController, String id, Object data) {
		UriComponentsBuilder restUrlBuilder = UriComponentsBuilder.fromUriString(getBaseUrlControllerByBUWithId());
		String buCode = requestUtil.getBu();
		String restUrl = restUrlBuilder.buildAndExpand(buCode, apiController, id).toUriString();
		rt.put(restUrl, data);
	}

	private void patch(String apiController, String id, Object data) {
		UriComponentsBuilder restUrlBuilder = UriComponentsBuilder.fromUriString(getBaseUrlControllerByBUWithId());
		String buCode = requestUtil.getBu();
		String restUrl = restUrlBuilder.buildAndExpand(buCode, apiController, id).toUriString();
		// Create HttpEntity
		final HttpEntity<Object> requestEntity = new HttpEntity<>(data);

		rt.exchange(restUrl, HttpMethod.PATCH, requestEntity, Void.class);
	}

	private void delete(String apiController, String id) {
		UriComponentsBuilder restUrlBuilder = UriComponentsBuilder.fromUriString(getBaseUrlControllerByBUWithId());
		String buCode = requestUtil.getBu();
		String restUrl = restUrlBuilder.buildAndExpand(buCode, apiController, id).toUriString();
		rt.delete(restUrl);
	}

	public PaginatedDataBean< MissionTableModel> listOrdersPaginated(String heroSegment,
			DataTableRequestBean dataTableRequestBean, String commandePar) throws IOException {
		Class<MissionTableModel> clazz = MissionTableModel.class;// MissionApiModel
		String jsonString = getPaginated(heroSegment, "mission-indirect-headers",
				dataTableRequestBean).getBody();
		return objectMapper.readValue(jsonString,
				objectMapper.getTypeFactory().constructParametricType(PaginatedDataBean.class, clazz));
	}

	public MissionTableModel getOrder(String heroSegment, String idMission) throws IOException {
		Class<MissionTableModel> clazz = MissionTableModel.class;// MissionApiModel
		String jsonString = get(heroSegment, "mission-indirect-headers/" + idMission).getBody();
		return objectMapper.readValue(jsonString, objectMapper.getTypeFactory().constructSimpleType(clazz, null));
	}

	public void newOrder(String heroSegment, MissionTableModel missionWebModel) {
		MissionApiModel missionApiModel = dozerBeanMapper.map(missionWebModel, MissionApiModel.class);
		post(heroSegment, "mission-indirect-headers/create", missionApiModel);
	}

	public void putOrder(MissionTableModel missionWebModel) {
		put("mission-indirect-headers", missionWebModel.getId().toString(), missionWebModel);
	}

	public void patchOrder(MissionTableModel missionWebModel) {
		patch("mission-indirect-headers", missionWebModel.getId().toString(), missionWebModel);
	}

	public void deleteOrder(String id) {
		delete("mission-indirect-headers", id);
	}
}
