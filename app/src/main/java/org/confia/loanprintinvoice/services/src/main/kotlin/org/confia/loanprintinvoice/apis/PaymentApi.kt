package org.confia.loanprintinvoice.apis

import org.confia.loanprintinvoice.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.google.gson.annotations.SerializedName

import org.confia.loanprintinvoice.models.BorrowerClientDtoWithActiveLoans
import org.confia.loanprintinvoice.models.NewPaymentDto
import org.confia.loanprintinvoice.models.PaymentDetailsResponseDto
import org.confia.loanprintinvoice.models.PaymentResponseDto

interface PaymentApi {
    /**
     * GET api/Payment/GetDetailed/{id}
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param id 
     * @param token  (optional)
     * @return [BorrowerClientDtoWithActiveLoans]
     */
    @GET("api/Payment/GetDetailed/{id}")
    suspend fun getDetailed(@Path("id") id: java.util.UUID, @Query("token") token: kotlin.String? = null): Response<BorrowerClientDtoWithActiveLoans>

    /**
     * GET api/Payment/GetPaymentDetail
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param paymentId  (optional)
     * @return [PaymentDetailsResponseDto]
     */
    @GET("api/Payment/GetPaymentDetail")
    suspend fun getPaymentDetail(@Query("paymentId") paymentId: java.util.UUID? = null): Response<PaymentDetailsResponseDto>

    /**
     * POST api/Payment/Pay
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param newPaymentDto  (optional)
     * @return [PaymentResponseDto]
     */
    @POST("api/Payment/Pay")
    suspend fun pay(@Body newPaymentDto: NewPaymentDto? = null): Response<PaymentResponseDto>

}
