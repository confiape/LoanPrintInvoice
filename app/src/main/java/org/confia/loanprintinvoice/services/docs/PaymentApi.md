# PaymentApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getDetailed**](PaymentApi.md#getDetailed) | **GET** api/Payment/GetDetailed/{id} |  |
| [**getPaymentDetail**](PaymentApi.md#getPaymentDetail) | **GET** api/Payment/GetPaymentDetail |  |
| [**pay**](PaymentApi.md#pay) | **POST** api/Payment/Pay |  |





### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(PaymentApi::class.java)
val id : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | 
val token : kotlin.String = token_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : BorrowerClientDtoWithActiveLoans = webService.getDetailed(id, token)
}
```

### Parameters
| **id** | **java.util.UUID**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**|  | [optional] |

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
val webService = apiClient.createWebservice(PaymentApi::class.java)
val paymentId : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | 

launch(Dispatchers.IO) {
    val result : PaymentDetailsResponseDto = webService.getPaymentDetail(paymentId)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **paymentId** | **java.util.UUID**|  | [optional] |

### Return type

[**PaymentDetailsResponseDto**](PaymentDetailsResponseDto.md)

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
val webService = apiClient.createWebservice(PaymentApi::class.java)
val newPaymentDto : NewPaymentDto =  // NewPaymentDto | 

launch(Dispatchers.IO) {
    val result : PaymentResponseDto = webService.pay(newPaymentDto)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **newPaymentDto** | [**NewPaymentDto**](NewPaymentDto.md)|  | [optional] |

### Return type

[**PaymentResponseDto**](PaymentResponseDto.md)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/*+json
 - **Accept**: text/plain, application/json, text/json

