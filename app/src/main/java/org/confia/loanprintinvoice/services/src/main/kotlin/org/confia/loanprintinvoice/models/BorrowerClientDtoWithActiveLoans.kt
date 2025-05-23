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

import org.confia.loanprintinvoice.models.CompanyDto
import org.confia.loanprintinvoice.models.LoanDtoAndPayments
import org.confia.loanprintinvoice.models.PersonDto

import com.google.gson.annotations.SerializedName

/**
 * 
 *
 * @param id 
 * @param person 
 * @param displayName 
 * @param company 
 * @param loans 
 */


data class BorrowerClientDtoWithActiveLoans (

    @SerializedName("id")
    val id: java.util.UUID,

    @SerializedName("person")
    val person: PersonDto,

    @SerializedName("displayName")
    val displayName: kotlin.String,

    @SerializedName("company")
    val company: CompanyDto,

    @SerializedName("loans")
    val loans: kotlin.collections.List<LoanDtoAndPayments>

) {


}

