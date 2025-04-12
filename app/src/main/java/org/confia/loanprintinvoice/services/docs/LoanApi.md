# LoanApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createLoan**](LoanApi.md#createLoan) | **POST** api/Loan/CreateLoan |  |





### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(LoanApi::class.java)
val createLoanDto : CreateLoanDto =  // CreateLoanDto | 

launch(Dispatchers.IO) {
    val result : LoanDtoAndPayments = webService.createLoan(createLoanDto)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createLoanDto** | [**CreateLoanDto**](CreateLoanDto.md)|  | [optional] |

### Return type

[**LoanDtoAndPayments**](LoanDtoAndPayments.md)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/*+json
 - **Accept**: text/plain, application/json, text/json

