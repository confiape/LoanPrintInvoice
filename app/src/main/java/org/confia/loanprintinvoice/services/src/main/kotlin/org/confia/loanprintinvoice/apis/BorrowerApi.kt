package org.confia.loanprintinvoice.apis

import org.confia.loanprintinvoice.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.google.gson.annotations.SerializedName

import org.confia.loanprintinvoice.models.BorrowerClientDtoWithActiveLoans
import org.confia.loanprintinvoice.models.CreateBorrower

interface BorrowerApi {
    /**
     * POST api/Borrower/CreateBorrower
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param createBorrower  (optional)
     * @return [BorrowerClientDtoWithActiveLoans]
     */
    @POST("api/Borrower/CreateBorrower")
    suspend fun createBorrower(@Body createBorrower: CreateBorrower? = null): Response<BorrowerClientDtoWithActiveLoans>

    /**
     * GET api/Borrower/GetAllWithActiveLoans
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @return [kotlin.collections.List<BorrowerClientDtoWithActiveLoans>]
     */
    @GET("api/Borrower/GetAllWithActiveLoans")
    suspend fun getAllWithActiveLoans(): Response<kotlin.collections.List<BorrowerClientDtoWithActiveLoans>>

    /**
     * GET api/Borrower/GetByIdWithActiveLoans
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param borrowerClientId  (optional)
     * @return [BorrowerClientDtoWithActiveLoans]
     */
    @GET("api/Borrower/GetByIdWithActiveLoans")
    suspend fun getByIdWithActiveLoans(@Query("borrowerClientId") borrowerClientId: java.util.UUID? = null): Response<BorrowerClientDtoWithActiveLoans>

    /**
     * POST api/Borrower/UpdateBorrower
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param borrowerClientId  (optional)
     * @param createBorrower  (optional)
     * @return [BorrowerClientDtoWithActiveLoans]
     */
    @POST("api/Borrower/UpdateBorrower")
    suspend fun updateBorrower(@Query("borrowerClientId") borrowerClientId: java.util.UUID? = null, @Body createBorrower: CreateBorrower? = null): Response<BorrowerClientDtoWithActiveLoans>

}
