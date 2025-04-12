# FileApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**upload**](FileApi.md#upload) | **POST** api/File/Upload |  |





### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(FileApi::class.java)
val file : java.io.File = BINARY_DATA_HERE // java.io.File | 

launch(Dispatchers.IO) {
    webService.upload(file)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **file** | **java.io.File**|  | [optional] |

### Return type

null (empty response body)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: Not defined

