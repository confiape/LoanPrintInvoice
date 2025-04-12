package org.confia.loanprintinvoice.apis

import org.confia.loanprintinvoice.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.google.gson.annotations.SerializedName

import org.confia.loanprintinvoice.models.CompanyDto
import org.confia.loanprintinvoice.models.SaveCompanyDto

interface CompanyApi {
    /**
     * POST api/Company/CreateCompany
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param saveCompanyDto  (optional)
     * @return [CompanyDto]
     */
    @POST("api/Company/CreateCompany")
    suspend fun createCompany(@Body saveCompanyDto: SaveCompanyDto? = null): Response<CompanyDto>

    /**
     * DELETE api/Company/DeleteCompany
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param id  (optional)
     * @return [Unit]
     */
    @DELETE("api/Company/DeleteCompany")
    suspend fun deleteCompany(@Query("id") id: java.util.UUID? = null): Response<Unit>

    /**
     * GET api/Company/GetAllCompanies
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @return [kotlin.collections.List<CompanyDto>]
     */
    @GET("api/Company/GetAllCompanies")
    suspend fun getAllCompanies(): Response<kotlin.collections.List<CompanyDto>>

    /**
     * GET api/Company/GetCompanyById
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param id  (optional)
     * @return [CompanyDto]
     */
    @GET("api/Company/GetCompanyById")
    suspend fun getCompanyById(@Query("id") id: java.util.UUID? = null): Response<CompanyDto>

    /**
     * PUT api/Company/UpdateCompany
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param companyDto  (optional)
     * @return [CompanyDto]
     */
    @PUT("api/Company/UpdateCompany")
    suspend fun updateCompany(@Body companyDto: CompanyDto? = null): Response<CompanyDto>

}
