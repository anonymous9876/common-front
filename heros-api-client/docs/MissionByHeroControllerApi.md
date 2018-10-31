# MissionByHeroControllerApi

All URIs are relative to *https://localhost:8082*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listMissionPaginatedUsingGET**](MissionByHeroControllerApi.md#listMissionPaginatedUsingGET) | **GET** /api/business-units/{buCode}/heros/{hero}/missions | Retrieves a list


<a name="listMissionPaginatedUsingGET"></a>
# **listMissionPaginatedUsingGET**
> PaginableRestResultMissionDto listMissionPaginatedUsingGET(buCode, hero, filter, limit, offset, search, sort)

Retrieves a list

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MissionByHeroControllerApi;


MissionByHeroControllerApi apiInstance = new MissionByHeroControllerApi();
String buCode = "buCode_example"; // String | buCode
String hero = "hero_example"; // String | hero
String filter = "filter_example"; // String | filter
Integer limit = 56; // Integer | limit
Integer offset = 56; // Integer | offset
String search = "search_example"; // String | search
List<String> sort = Arrays.asList("sort_example"); // List<String> | sort
try {
    PaginableRestResultMissionDto result = apiInstance.listMissionPaginatedUsingGET(buCode, hero, filter, limit, offset, search, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MissionByHeroControllerApi#listMissionPaginatedUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **buCode** | **String**| buCode |
 **hero** | **String**| hero |
 **filter** | **String**| filter | [optional]
 **limit** | **Integer**| limit | [optional]
 **offset** | **Integer**| offset | [optional]
 **search** | **String**| search | [optional]
 **sort** | [**List&lt;String&gt;**](String.md)| sort | [optional]

### Return type

[**PaginableRestResultMissionDto**](PaginableRestResultMissionDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

