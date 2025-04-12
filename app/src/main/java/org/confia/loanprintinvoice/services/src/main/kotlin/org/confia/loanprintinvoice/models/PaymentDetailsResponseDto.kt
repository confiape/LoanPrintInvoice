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
 * @param name 
 * @param dni 
 * @param loanAmount 
 * @param loanTotalAmount 
 * @param paymentAmount 
 * @param paymentDate 
 * @param paymentNumber 
 * @param paymentSum 
 */


data class PaymentDetailsResponseDto (

    @SerializedName("name")
    val name: kotlin.String,

    @SerializedName("dni")
    val dni: kotlin.String,

    @SerializedName("loanAmount")
    val loanAmount: kotlin.Double,

    @SerializedName("loanTotalAmount")
    val loanTotalAmount: kotlin.Double,

    @SerializedName("paymentAmount")
    val paymentAmount: kotlin.Double,

    @SerializedName("paymentDate")
    val paymentDate: java.time.OffsetDateTime,

    @SerializedName("paymentNumber")
    val paymentNumber: kotlin.Int,

    @SerializedName("paymentSum")
    val paymentSum: kotlin.Double

) {


}

