package org.confia.loanprintinvoice.apis

import org.confia.loanprintinvoice.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.google.gson.annotations.SerializedName

import org.confia.loanprintinvoice.models.CreateLoanDto
import org.confia.loanprintinvoice.models.LoanDtoAndPayments

interface LoanApi {
    /**
     * POST api/Loan/CreateLoan
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param createLoanDto  (optional)
     * @return [LoanDtoAndPayments]
     */
    @POST("api/Loan/CreateLoan")
    suspend fun createLoan(@Body createLoanDto: CreateLoanDto? = null): Response<LoanDtoAndPayments>

}
