package org.confia.loanprintinvoice.apis

import org.confia.loanprintinvoice.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.google.gson.annotations.SerializedName

import org.confia.loanprintinvoice.models.LoanDto
import org.confia.loanprintinvoice.models.PaymentDto
import org.confia.loanprintinvoice.models.ReportPaymentByDayDto

interface ReportsApi {
    /**
     * GET api/Reports/GeneratePaymentReceipt/{id}/receipt.png
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param id 
     * @return [Unit]
     */
    @GET("api/Reports/GeneratePaymentReceipt/{id}/receipt.png")
    suspend fun generatePaymentReceipt(@Path("id") id: java.util.UUID): Response<Unit>

    /**
     * GET api/Reports/ReportLoansByClientId
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param clientId  (optional)
     * @return [kotlin.collections.List<LoanDto>]
     */
    @GET("api/Reports/ReportLoansByClientId")
    suspend fun reportLoansByClientId(@Query("clientId") clientId: java.util.UUID? = null): Response<kotlin.collections.List<LoanDto>>

    /**
     * GET api/Reports/ReportPaymentByDay
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param dateTime  (optional)
     * @return [ReportPaymentByDayDto]
     */
    @GET("api/Reports/ReportPaymentByDay")
    suspend fun reportPaymentByDay(@Query("dateTime") dateTime: java.time.OffsetDateTime? = null): Response<ReportPaymentByDayDto>

    /**
     * GET api/Reports/ReportPaymentByLoan
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param loanId  (optional)
     * @return [kotlin.collections.List<PaymentDto>]
     */
    @GET("api/Reports/ReportPaymentByLoan")
    suspend fun reportPaymentByLoan(@Query("loanId") loanId: java.util.UUID? = null): Response<kotlin.collections.List<PaymentDto>>

}
