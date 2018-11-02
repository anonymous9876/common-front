package name.anonymous.common.front.app.heros.controller.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import io.swagger.client.model.MissionDto;
import name.anonymous.common.front.app.heros.service.delegate.MissionGService;

@RestController
@RequestMapping({
"/{userType}/{buCode}/heros"})
public class MissionController {
	@Autowired
	private MissionGService missionService;

	@DeleteMapping("{missionId}")
	public void deleteMissionUsingDELETE(@PathVariable String buCode, @PathVariable String missionId) throws RestClientException {
		missionService.deleteMissionUsingDELETE(buCode, missionId);
	}

	@PatchMapping("{missionId}")
	public void patchMissionUsingPATCH(@PathVariable String buCode, MissionDto mission, @PathVariable String missionId) throws RestClientException {
		missionService.patchMissionUsingPATCH(buCode, mission, missionId);
	}

	@PutMapping("{missionId}")
	public void putMissionUsingPUT(@PathVariable String buCode, MissionDto mission, @PathVariable String missionId) throws RestClientException {
		missionService.putMissionUsingPUT(buCode, mission, missionId);
	}

	@PostMapping
	public void postMissionUsingPOST(@PathVariable String buCode, MissionDto missionDto) throws RestClientException {
		missionService.postMissionUsingPOST(buCode, missionDto);
	}
}
