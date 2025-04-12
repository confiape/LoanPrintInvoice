package org.confia.loanprintinvoice.apis

import org.confia.loanprintinvoice.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.google.gson.annotations.SerializedName

import org.confia.loanprintinvoice.models.PermissionDto
import org.confia.loanprintinvoice.models.RoleDto
import org.confia.loanprintinvoice.models.SaveRoleDto
import org.confia.loanprintinvoice.models.SaveUserDto
import org.confia.loanprintinvoice.models.UserDto

interface UserApi {
    /**
     * DELETE api/User/DeleteRole
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param roleId  (optional)
     * @return [Unit]
     */
    @DELETE("api/User/DeleteRole")
    suspend fun deleteRole(@Query("roleId") roleId: java.util.UUID? = null): Response<Unit>

    /**
     * DELETE api/User/DeleteUser
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param userId  (optional)
     * @return [Unit]
     */
    @DELETE("api/User/DeleteUser")
    suspend fun deleteUser(@Query("userId") userId: java.util.UUID? = null): Response<Unit>

    /**
     * GET api/User/GetAllPermissions
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @return [kotlin.collections.List<PermissionDto>]
     */
    @GET("api/User/GetAllPermissions")
    suspend fun getAllPermissions(): Response<kotlin.collections.List<PermissionDto>>

    /**
     * GET api/User/GetAllRoles
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @return [kotlin.collections.List<RoleDto>]
     */
    @GET("api/User/GetAllRoles")
    suspend fun getAllRoles(): Response<kotlin.collections.List<RoleDto>>

    /**
     * GET api/User/GetAllUsers
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @return [kotlin.collections.List<UserDto>]
     */
    @GET("api/User/GetAllUsers")
    suspend fun getAllUsers(): Response<kotlin.collections.List<UserDto>>

    /**
     * GET api/User/GetCurrentPermissions
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @return [kotlin.collections.List<PermissionDto>]
     */
    @GET("api/User/GetCurrentPermissions")
    suspend fun getCurrentPermissions(): Response<kotlin.collections.List<PermissionDto>>

    /**
     * GET api/User/GetCurrentUser
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @return [UserDto]
     */
    @GET("api/User/GetCurrentUser")
    suspend fun getCurrentUser(): Response<UserDto>

    /**
     * POST api/User/SaveRole
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param saveRoleDto  (optional)
     * @return [RoleDto]
     */
    @POST("api/User/SaveRole")
    suspend fun saveRole(@Body saveRoleDto: SaveRoleDto? = null): Response<RoleDto>

    /**
     * POST api/User/SaveUser
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param saveUserDto  (optional)
     * @return [UserDto]
     */
    @POST("api/User/SaveUser")
    suspend fun saveUser(@Body saveUserDto: SaveUserDto? = null): Response<UserDto>

    /**
     * GET api/User/SearchByIdOrDni
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param idOrDni  (optional)
     * @return [UserDto]
     */
    @GET("api/User/SearchByIdOrDni")
    suspend fun searchByIdOrDni(@Query("idOrDni") idOrDni: kotlin.String? = null): Response<UserDto>

}
