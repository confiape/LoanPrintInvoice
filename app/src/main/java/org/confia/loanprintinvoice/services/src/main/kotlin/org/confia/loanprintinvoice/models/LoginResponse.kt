/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.confia.loanprintinvoice.models

import org.confia.loanprintinvoice.models.PersonDto

import com.google.gson.annotations.SerializedName

/**
 * 
 *
 * @param user 
 * @param accessToken 
 * @param tokenType 
 */


data class LoginResponse (

    @SerializedName("user")
    val user: PersonDto,

    @SerializedName("accessToken")
    val accessToken: kotlin.String,

    @SerializedName("tokenType")
    val tokenType: kotlin.String

) {


}

