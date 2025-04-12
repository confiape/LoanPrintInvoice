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
 * Values: Daily,Weekly,Monthly
 */

enum class LoanType(val value: kotlin.String) {

    @SerializedName(value = "Daily")
    Daily("Daily"),

    @SerializedName(value = "Weekly")
    Weekly("Weekly"),

    @SerializedName(value = "Monthly")
    Monthly("Monthly");

    /**
     * Override [toString()] to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): kotlin.String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is LoanType) "$data" else null

        /**
         * Returns a valid [LoanType] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): LoanType? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

