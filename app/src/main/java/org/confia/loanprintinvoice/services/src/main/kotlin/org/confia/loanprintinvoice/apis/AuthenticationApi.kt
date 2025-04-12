package org.confia.loanprintinvoice.apis

import org.confia.loanprintinvoice.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.google.gson.annotations.SerializedName

import org.confia.loanprintinvoice.models.LoginDto
import org.confia.loanprintinvoice.models.LoginResponse
import org.confia.loanprintinvoice.models.TokenDto

interface AuthenticationApi {
    /**
     * POST api/Authentication/GetAuthorizationToken
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @return [LoginResponse]
     */
    @POST("api/Authentication/GetAuthorizationToken")
    suspend fun getAuthorizationToken(): Response<LoginResponse>

    /**
     * GET api/Authentication/IsAuthenticated
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @return [kotlin.Boolean]
     */
    @GET("api/Authentication/IsAuthenticated")
    suspend fun isAuthenticated(): Response<kotlin.Boolean>

    /**
     * POST api/Authentication/LogIn
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param loginDto  (optional)
     * @return [Unit]
     */
    @POST("api/Authentication/LogIn")
    suspend fun logIn(@Body loginDto: LoginDto? = null): Response<Unit>

    /**
     * GET api/Authentication/LogOut
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @return [Unit]
     */
    @GET("api/Authentication/LogOut")
    suspend fun logOut(): Response<Unit>

    /**
     * POST api/Authentication/LoginWithGoogleToken
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param tokenDto  (optional)
     * @return [Unit]
     */
    @POST("api/Authentication/LoginWithGoogleToken")
    suspend fun loginWithGoogleToken(@Body tokenDto: TokenDto? = null): Response<Unit>

    /**
     * POST api/Authentication/RefreshAuthenticationToken
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @return [Unit]
     */
    @POST("api/Authentication/RefreshAuthenticationToken")
    suspend fun refreshAuthenticationToken(): Response<Unit>

}
