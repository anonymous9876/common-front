package io.swagger.client.api;

import io.swagger.client.ApiClient;

import io.swagger.client.model.PaginableRestResultMissionDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-31T17:38:54.800+01:00")
@Component("io.swagger.client.api.MissionByHeroControllerApi")
public class MissionByHeroControllerApi {
    private ApiClient apiClient;

    public MissionByHeroControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public MissionByHeroControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Retrieves a list
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param buCode buCode
     * @param hero hero
     * @param filter filter
     * @param limit limit
     * @param offset offset
     * @param search search
     * @param sort sort
     * @return PaginableRestResultMissionDto
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PaginableRestResultMissionDto listMissionPaginatedUsingGET(String buCode, String hero, String filter, Integer limit, Integer offset, String search, List<String> sort) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'buCode' is set
        if (buCode == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'buCode' when calling listMissionPaginatedUsingGET");
        }
        
        // verify the required parameter 'hero' is set
        if (hero == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'hero' when calling listMissionPaginatedUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("buCode", buCode);
        uriVariables.put("hero", hero);
        String path = UriComponentsBuilder.fromPath("/api/business-units/{buCode}/heros/{hero}/missions").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter", filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "search", search));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "sort", sort));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<PaginableRestResultMissionDto> returnType = new ParameterizedTypeReference<PaginableRestResultMissionDto>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
