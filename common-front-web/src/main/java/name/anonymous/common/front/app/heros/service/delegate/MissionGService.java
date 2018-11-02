package name.anonymous.common.front.app.heros.service.delegate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import io.swagger.client.api.MissionControllerApi;
import io.swagger.client.model.MissionDto;

@Service
public class MissionGService {
	private MissionControllerApi apiInstance = new MissionControllerApi();

	public void deleteMissionUsingDELETE(String buCode, String missionId) throws RestClientException {
		apiInstance.deleteMissionUsingDELETE(buCode, missionId);
	}

	public void patchMissionUsingPATCH(String buCode, MissionDto mission, String missionId) throws RestClientException {
		apiInstance.patchMissionUsingPATCH(buCode, mission, missionId);
	}

	public void postMissionUsingPOST(String buCode, MissionDto missionDto) throws RestClientException {
		apiInstance.postMissionUsingPOST(buCode, missionDto);
	}

	public void putMissionUsingPUT(String buCode, MissionDto mission, String missionId) throws RestClientException {
		apiInstance.putMissionUsingPUT(buCode, mission, missionId);
	}


}
