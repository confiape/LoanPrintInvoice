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


import com.google.gson.annotations.SerializedName

/**
 * 
 *
 * @param email 
 * @param password 
 */


data class LoginDto (

    @SerializedName("email")
    val email: kotlin.String,

    @SerializedName("password")
    val password: kotlin.String

) {


}

