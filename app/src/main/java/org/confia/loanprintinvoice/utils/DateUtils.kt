package org.confia.loanprintinvoice.utils

import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDate(): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
    return formatter.format(Date())
}
