# CompanyApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createCompany**](CompanyApi.md#createCompany) | **POST** api/Company/CreateCompany |  |
| [**deleteCompany**](CompanyApi.md#deleteCompany) | **DELETE** api/Company/DeleteCompany |  |
| [**getAllCompanies**](CompanyApi.md#getAllCompanies) | **GET** api/Company/GetAllCompanies |  |
| [**getCompanyById**](CompanyApi.md#getCompanyById) | **GET** api/Company/GetCompanyById |  |
| [**updateCompany**](CompanyApi.md#updateCompany) | **PUT** api/Company/UpdateCompany |  |





### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(CompanyApi::class.java)
val saveCompanyDto : SaveCompanyDto =  // SaveCompanyDto | 

launch(Dispatchers.IO) {
    val result : CompanyDto = webService.createCompany(saveCompanyDto)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **saveCompanyDto** | [**SaveCompanyDto**](SaveCompanyDto.md)|  | [optional] |

### Return type

[**CompanyDto**](CompanyDto.md)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/*+json
 - **Accept**: text/plain, application/json, text/json




### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(CompanyApi::class.java)
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | 

launch(Dispatchers.IO) {
    webService.deleteCompany(id)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **java.util.UUID**|  | [optional] |

### Return type

null (empty response body)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined




### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(CompanyApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<CompanyDto> = webService.getAllCompanies()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;CompanyDto&gt;**](CompanyDto.md)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json




### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(CompanyApi::class.java)
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | 

launch(Dispatchers.IO) {
    val result : CompanyDto = webService.getCompanyById(id)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **java.util.UUID**|  | [optional] |

### Return type

[**CompanyDto**](CompanyDto.md)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json




### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(CompanyApi::class.java)
val companyDto : CompanyDto =  // CompanyDto | 

launch(Dispatchers.IO) {
    val result : CompanyDto = webService.updateCompany(companyDto)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **companyDto** | [**CompanyDto**](CompanyDto.md)|  | [optional] |

### Return type

[**CompanyDto**](CompanyDto.md)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/*+json
 - **Accept**: text/plain, application/json, text/json

