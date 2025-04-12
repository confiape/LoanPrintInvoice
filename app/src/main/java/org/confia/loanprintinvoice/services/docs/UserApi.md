# UserApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**deleteRole**](UserApi.md#deleteRole) | **DELETE** api/User/DeleteRole |  |
| [**deleteUser**](UserApi.md#deleteUser) | **DELETE** api/User/DeleteUser |  |
| [**getAllPermissions**](UserApi.md#getAllPermissions) | **GET** api/User/GetAllPermissions |  |
| [**getAllRoles**](UserApi.md#getAllRoles) | **GET** api/User/GetAllRoles |  |
| [**getAllUsers**](UserApi.md#getAllUsers) | **GET** api/User/GetAllUsers |  |
| [**getCurrentPermissions**](UserApi.md#getCurrentPermissions) | **GET** api/User/GetCurrentPermissions |  |
| [**getCurrentUser**](UserApi.md#getCurrentUser) | **GET** api/User/GetCurrentUser |  |
| [**saveRole**](UserApi.md#saveRole) | **POST** api/User/SaveRole |  |
| [**saveUser**](UserApi.md#saveUser) | **POST** api/User/SaveUser |  |
| [**searchByIdOrDni**](UserApi.md#searchByIdOrDni) | **GET** api/User/SearchByIdOrDni |  |





### Example
```kotlin
// Import classes:
//import org.confia.loanprintinvoice.*
//import org.confia.loanprintinvoice.infrastructure.*
//import org.confia.loanprintinvoice.models.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(UserApi::class.java)
val roleId : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | 

launch(Dispatchers.IO) {
    webService.deleteRole(roleId)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **roleId** | **java.util.UUID**|  | [optional] |

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
val webService = apiClient.createWebservice(UserApi::class.java)
val userId : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | 

launch(Dispatchers.IO) {
    webService.deleteUser(userId)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **userId** | **java.util.UUID**|  | [optional] |

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
val webService = apiClient.createWebservice(UserApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PermissionDto> = webService.getAllPermissions()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;PermissionDto&gt;**](PermissionDto.md)

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
val webService = apiClient.createWebservice(UserApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<RoleDto> = webService.getAllRoles()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;RoleDto&gt;**](RoleDto.md)

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
val webService = apiClient.createWebservice(UserApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<UserDto> = webService.getAllUsers()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;UserDto&gt;**](UserDto.md)

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
val webService = apiClient.createWebservice(UserApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PermissionDto> = webService.getCurrentPermissions()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;PermissionDto&gt;**](PermissionDto.md)

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
val webService = apiClient.createWebservice(UserApi::class.java)

launch(Dispatchers.IO) {
    val result : UserDto = webService.getCurrentUser()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**UserDto**](UserDto.md)

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
val webService = apiClient.createWebservice(UserApi::class.java)
val saveRoleDto : SaveRoleDto =  // SaveRoleDto | 

launch(Dispatchers.IO) {
    val result : RoleDto = webService.saveRole(saveRoleDto)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **saveRoleDto** | [**SaveRoleDto**](SaveRoleDto.md)|  | [optional] |

### Return type

[**RoleDto**](RoleDto.md)

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
val webService = apiClient.createWebservice(UserApi::class.java)
val saveUserDto : SaveUserDto =  // SaveUserDto | 

launch(Dispatchers.IO) {
    val result : UserDto = webService.saveUser(saveUserDto)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **saveUserDto** | [**SaveUserDto**](SaveUserDto.md)|  | [optional] |

### Return type

[**UserDto**](UserDto.md)

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
val webService = apiClient.createWebservice(UserApi::class.java)
val idOrDni : kotlin.String = idOrDni_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UserDto = webService.searchByIdOrDni(idOrDni)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **idOrDni** | **kotlin.String**|  | [optional] |

### Return type

[**UserDto**](UserDto.md)

### Authorization


Configure Bearer:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

