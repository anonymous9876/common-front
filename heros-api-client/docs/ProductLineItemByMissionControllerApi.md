# ProductLineItemByMissionControllerApi

All URIs are relative to *https://localhost:8082*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listProductLineItemPaginatedUsingGET**](ProductLineItemByMissionControllerApi.md#listProductLineItemPaginatedUsingGET) | **GET** /api/business-units/{buCode}/missions/{idMission}/product-line-items | Retrieves a list


<a name="listProductLineItemPaginatedUsingGET"></a>
# **listProductLineItemPaginatedUsingGET**
> PaginableRestResultProductLineItemDto listProductLineItemPaginatedUsingGET(buCode, idMission, filter, limit, offset, search, sort)

Retrieves a list

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductLineItemByMissionControllerApi;


ProductLineItemByMissionControllerApi apiInstance = new ProductLineItemByMissionControllerApi();
String buCode = "buCode_example"; // String | buCode
String idMission = "idMission_example"; // String | idMission
String filter = "filter_example"; // String | filter
Integer limit = 56; // Integer | limit
Integer offset = 56; // Integer | offset
String search = "search_example"; // String | search
List<String> sort = Arrays.asList("sort_example"); // List<String> | sort
try {
    PaginableRestResultProductLineItemDto result = apiInstance.listProductLineItemPaginatedUsingGET(buCode, idMission, filter, limit, offset, search, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductLineItemByMissionControllerApi#listProductLineItemPaginatedUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **buCode** | **String**| buCode |
 **idMission** | **String**| idMission |
 **filter** | **String**| filter | [optional]
 **limit** | **Integer**| limit | [optional]
 **offset** | **Integer**| offset | [optional]
 **search** | **String**| search | [optional]
 **sort** | [**List&lt;String&gt;**](String.md)| sort | [optional]

### Return type

[**PaginableRestResultProductLineItemDto**](PaginableRestResultProductLineItemDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

