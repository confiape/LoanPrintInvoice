package org.confia.loanprintinvoice.apis

import org.confia.loanprintinvoice.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.google.gson.annotations.SerializedName


interface DefaultApi {
    /**
     * GET r/{code}
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param code 
     * @return [Unit]
     */
    @GET("r/{code}")
    suspend fun redirectToOriginal(@Path("code") code: kotlin.String): Response<Unit>

}
