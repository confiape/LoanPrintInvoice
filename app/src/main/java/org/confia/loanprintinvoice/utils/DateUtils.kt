package org.confia.loanprintinvoice.utils

import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun getCurrentDate(): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
    return formatter.format(Date())
}

fun formatOffsetDateTime(date: OffsetDateTime): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
        date.format(formatter)
    } catch (e: Exception) {
        date.toString()
    }
}