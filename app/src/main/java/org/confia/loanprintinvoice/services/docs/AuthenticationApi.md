# AuthenticationApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getAuthorizationToken**](AuthenticationApi.md#getAuthorizationToken) | **POST** api/Authentication/GetAuthorizationToken |  |
| [**isAuthenticated**](AuthenticationApi.md#isAuthenticated) | **GET** api/Authentication/IsAuthenticated |  |
| [**logIn**](AuthenticationApi.md#logIn) | **POST** api/Authentication/LogIn |  |
| [**logOut**](AuthenticationApi.md#logOut) | **GET** api/Authentication/LogOut |  |
| [**loginWithGoogleToken**](AuthenticationApi.md#loginWithGoogleToken) | **POST** api/Authentication/LoginWithGoogleToken |  |
| [**refreshAuthenticationToken**](AuthenticationApi.md#refreshAuthenticationToken) | **POST** api/Authentication/RefreshAuthenticationToken |  |





### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AuthenticationApi::class.java)

launch(Dispatchers.IO) {
    val result : LoginResponse = webService.getAuthorizationToken()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**LoginResponse**](LoginResponse.md)

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
val webService = apiClient.createWebservice(AuthenticationApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.Boolean = webService.isAuthenticated()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**kotlin.Boolean**

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
val webService = apiClient.createWebservice(AuthenticationApi::class.java)
val loginDto : LoginDto =  // LoginDto | 

launch(Dispatchers.IO) {
    webService.logIn(loginDto)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **loginDto** | [**LoginDto**](LoginDto.md)|  | [optional] |

### Return type

null (empty response body)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/*+json
 - **Accept**: Not defined




### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AuthenticationApi::class.java)

launch(Dispatchers.IO) {
    webService.logOut()
}
```

### Parameters
This endpoint does not need any parameter.

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
val webService = apiClient.createWebservice(AuthenticationApi::class.java)
val tokenDto : TokenDto =  // TokenDto | 

launch(Dispatchers.IO) {
    webService.loginWithGoogleToken(tokenDto)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **tokenDto** | [**TokenDto**](TokenDto.md)|  | [optional] |

### Return type

null (empty response body)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/*+json
 - **Accept**: Not defined




### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AuthenticationApi::class.java)

launch(Dispatchers.IO) {
    webService.refreshAuthenticationToken()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

