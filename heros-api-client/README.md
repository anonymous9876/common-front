# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>2.2.2</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:2.2.2"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-2.2.2.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.MissionByHeroControllerApi;

import java.io.File;
import java.util.*;

public class MissionByHeroControllerApiExample {

    public static void main(String[] args) {
        
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
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://localhost:8082*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*MissionByHeroControllerApi* | [**listMissionPaginatedUsingGET**](docs/MissionByHeroControllerApi.md#listMissionPaginatedUsingGET) | **GET** /api/business-units/{buCode}/heros/{hero}/missions | Retrieves a list
*MissionControllerApi* | [**deleteMissionUsingDELETE**](docs/MissionControllerApi.md#deleteMissionUsingDELETE) | **DELETE** /api/business-units/{buCode}/missions/{missionId} | delete
*MissionControllerApi* | [**patchMissionUsingPATCH**](docs/MissionControllerApi.md#patchMissionUsingPATCH) | **PATCH** /api/business-units/{buCode}/missions/{missionId} | patch
*MissionControllerApi* | [**postMissionUsingPOST**](docs/MissionControllerApi.md#postMissionUsingPOST) | **POST** /api/business-units/{buCode}/missions | post
*MissionControllerApi* | [**putMissionUsingPUT**](docs/MissionControllerApi.md#putMissionUsingPUT) | **PUT** /api/business-units/{buCode}/missions/{missionId} | put
*ProductLineItemByMissionControllerApi* | [**listProductLineItemPaginatedUsingGET**](docs/ProductLineItemByMissionControllerApi.md#listProductLineItemPaginatedUsingGET) | **GET** /api/business-units/{buCode}/missions/{idMission}/product-line-items | Retrieves a list


## Documentation for Models

 - [Address](docs/Address.md)
 - [Facet](docs/Facet.md)
 - [HeroDto](docs/HeroDto.md)
 - [MissionDto](docs/MissionDto.md)
 - [MissionState](docs/MissionState.md)
 - [Money](docs/Money.md)
 - [PaginableRestResultMissionDto](docs/PaginableRestResultMissionDto.md)
 - [PaginableRestResultProductLineItemDto](docs/PaginableRestResultProductLineItemDto.md)
 - [Person](docs/Person.md)
 - [Product](docs/Product.md)
 - [ProductLineItemDto](docs/ProductLineItemDto.md)
 - [RestFilter](docs/RestFilter.md)
 - [Version](docs/Version.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

email@a.com

