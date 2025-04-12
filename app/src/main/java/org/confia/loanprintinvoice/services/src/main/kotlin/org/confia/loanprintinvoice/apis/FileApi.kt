package org.confia.loanprintinvoice.apis

import org.confia.loanprintinvoice.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.google.gson.annotations.SerializedName


import okhttp3.MultipartBody

interface FileApi {
    /**
     * POST api/File/Upload
     * 
     * 
     * Responses:
     *  - 200: OK
     *
     * @param file  (optional)
     * @return [Unit]
     */
    @Multipart
    @POST("api/File/Upload")
    suspend fun upload(@Part file: MultipartBody.Part? = null): Response<Unit>

}
