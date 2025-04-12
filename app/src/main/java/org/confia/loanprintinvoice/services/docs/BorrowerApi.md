# BorrowerApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createBorrower**](BorrowerApi.md#createBorrower) | **POST** api/Borrower/CreateBorrower |  |
| [**getAllWithActiveLoans**](BorrowerApi.md#getAllWithActiveLoans) | **GET** api/Borrower/GetAllWithActiveLoans |  |
| [**getByIdWithActiveLoans**](BorrowerApi.md#getByIdWithActiveLoans) | **GET** api/Borrower/GetByIdWithActiveLoans |  |
| [**updateBorrower**](BorrowerApi.md#updateBorrower) | **POST** api/Borrower/UpdateBorrower |  |





### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(BorrowerApi::class.java)
val createBorrower : CreateBorrower =  // CreateBorrower | 

launch(Dispatchers.IO) {
    val result : BorrowerClientDtoWithActiveLoans = webService.createBorrower(createBorrower)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createBorrower** | [**CreateBorrower**](CreateBorrower.md)|  | [optional] |

### Return type

[**BorrowerClientDtoWithActiveLoans**](BorrowerClientDtoWithActiveLoans.md)

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
val webService = apiClient.createWebservice(BorrowerApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<BorrowerClientDtoWithActiveLoans> = webService.getAllWithActiveLoans()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;BorrowerClientDtoWithActiveLoans&gt;**](BorrowerClientDtoWithActiveLoans.md)

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
val webService = apiClient.createWebservice(BorrowerApi::class.java)
val borrowerClientId : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | 

launch(Dispatchers.IO) {
    val result : BorrowerClientDtoWithActiveLoans = webService.getByIdWithActiveLoans(borrowerClientId)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **borrowerClientId** | **java.util.UUID**|  | [optional] |

### Return type

[**BorrowerClientDtoWithActiveLoans**](BorrowerClientDtoWithActiveLoans.md)

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
val webService = apiClient.createWebservice(BorrowerApi::class.java)
val borrowerClientId : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | 
val createBorrower : CreateBorrower =  // CreateBorrower | 

launch(Dispatchers.IO) {
    val result : BorrowerClientDtoWithActiveLoans = webService.updateBorrower(borrowerClientId, createBorrower)
}
```

### Parameters
| **borrowerClientId** | **java.util.UUID**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createBorrower** | [**CreateBorrower**](CreateBorrower.md)|  | [optional] |

### Return type

[**BorrowerClientDtoWithActiveLoans**](BorrowerClientDtoWithActiveLoans.md)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/*+json
 - **Accept**: text/plain, application/json, text/json

