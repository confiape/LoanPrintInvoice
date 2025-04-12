# ReportsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**generatePaymentReceipt**](ReportsApi.md#generatePaymentReceipt) | **GET** api/Reports/GeneratePaymentReceipt/{id}/receipt.png |  |
| [**reportLoansByClientId**](ReportsApi.md#reportLoansByClientId) | **GET** api/Reports/ReportLoansByClientId |  |
| [**reportPaymentByDay**](ReportsApi.md#reportPaymentByDay) | **GET** api/Reports/ReportPaymentByDay |  |
| [**reportPaymentByLoan**](ReportsApi.md#reportPaymentByLoan) | **GET** api/Reports/ReportPaymentByLoan |  |





### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(ReportsApi::class.java)
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | 

launch(Dispatchers.IO) {
    webService.generatePaymentReceipt(id)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **java.util.UUID**|  | |

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
val webService = apiClient.createWebservice(ReportsApi::class.java)
val clientId : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<LoanDto> = webService.reportLoansByClientId(clientId)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **clientId** | **java.util.UUID**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;LoanDto&gt;**](LoanDto.md)

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
val webService = apiClient.createWebservice(ReportsApi::class.java)
val dateTime : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 

launch(Dispatchers.IO) {
    val result : ReportPaymentByDayDto = webService.reportPaymentByDay(dateTime)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **dateTime** | **java.time.OffsetDateTime**|  | [optional] |

### Return type

[**ReportPaymentByDayDto**](ReportPaymentByDayDto.md)

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
val webService = apiClient.createWebservice(ReportsApi::class.java)
val loanId : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PaymentDto> = webService.reportPaymentByLoan(loanId)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **loanId** | **java.util.UUID**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;PaymentDto&gt;**](PaymentDto.md)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

