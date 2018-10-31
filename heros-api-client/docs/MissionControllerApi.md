# MissionControllerApi

All URIs are relative to *https://localhost:8082*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteMissionUsingDELETE**](MissionControllerApi.md#deleteMissionUsingDELETE) | **DELETE** /api/business-units/{buCode}/missions/{missionId} | delete
[**patchMissionUsingPATCH**](MissionControllerApi.md#patchMissionUsingPATCH) | **PATCH** /api/business-units/{buCode}/missions/{missionId} | patch
[**postMissionUsingPOST**](MissionControllerApi.md#postMissionUsingPOST) | **POST** /api/business-units/{buCode}/missions | post
[**putMissionUsingPUT**](MissionControllerApi.md#putMissionUsingPUT) | **PUT** /api/business-units/{buCode}/missions/{missionId} | put


<a name="deleteMissionUsingDELETE"></a>
# **deleteMissionUsingDELETE**
> deleteMissionUsingDELETE(buCode, missionId)

delete

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MissionControllerApi;


MissionControllerApi apiInstance = new MissionControllerApi();
String buCode = "buCode_example"; // String | buCode
String missionId = "missionId_example"; // String | missionId
try {
    apiInstance.deleteMissionUsingDELETE(buCode, missionId);
} catch (ApiException e) {
    System.err.println("Exception when calling MissionControllerApi#deleteMissionUsingDELETE");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **buCode** | **String**| buCode |
 **missionId** | **String**| missionId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="patchMissionUsingPATCH"></a>
# **patchMissionUsingPATCH**
> patchMissionUsingPATCH(buCode, mission, missionId)

patch

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MissionControllerApi;


MissionControllerApi apiInstance = new MissionControllerApi();
String buCode = "buCode_example"; // String | buCode
MissionDto mission = new MissionDto(); // MissionDto | mission
String missionId = "missionId_example"; // String | missionId
try {
    apiInstance.patchMissionUsingPATCH(buCode, mission, missionId);
} catch (ApiException e) {
    System.err.println("Exception when calling MissionControllerApi#patchMissionUsingPATCH");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **buCode** | **String**| buCode |
 **mission** | [**MissionDto**](MissionDto.md)| mission |
 **missionId** | **String**| missionId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="postMissionUsingPOST"></a>
# **postMissionUsingPOST**
> postMissionUsingPOST(buCode, missionDto)

post

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MissionControllerApi;


MissionControllerApi apiInstance = new MissionControllerApi();
String buCode = "buCode_example"; // String | buCode
MissionDto missionDto = new MissionDto(); // MissionDto | missionDto
try {
    apiInstance.postMissionUsingPOST(buCode, missionDto);
} catch (ApiException e) {
    System.err.println("Exception when calling MissionControllerApi#postMissionUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **buCode** | **String**| buCode |
 **missionDto** | [**MissionDto**](MissionDto.md)| missionDto |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="putMissionUsingPUT"></a>
# **putMissionUsingPUT**
> putMissionUsingPUT(buCode, mission, missionId)

put

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MissionControllerApi;


MissionControllerApi apiInstance = new MissionControllerApi();
String buCode = "buCode_example"; // String | buCode
MissionDto mission = new MissionDto(); // MissionDto | mission
String missionId = "missionId_example"; // String | missionId
try {
    apiInstance.putMissionUsingPUT(buCode, mission, missionId);
} catch (ApiException e) {
    System.err.println("Exception when calling MissionControllerApi#putMissionUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **buCode** | **String**| buCode |
 **mission** | [**MissionDto**](MissionDto.md)| mission |
 **missionId** | **String**| missionId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

