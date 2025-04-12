package org.confia.loanprintinvoice.printer

import org.confia.loanprintinvoice.utils.getCurrentDate

fun printReceipt(onError: (String) -> Unit) {
    try {
        val commands = mutableListOf<ByteArray>()

        commands += byteArrayOf(0x1B, 0x40) // Reset
        commands += byteArrayOf(0x1B, 0x61, 0x01) // Center
        commands += "Mi Negocio\nDirección: Calle Principal 123\nTeléfono: +123 456 789\nFecha: ${getCurrentDate()}\n\n".toByteArray()

        commands += byteArrayOf(0x1B, 0x61, 0x00) // Left
        commands += """
            --------------------------------
            Producto          Precio   Cantidad
            --------------------------------
            Café americano    $5.00      2
            Té verde          $4.50      1
            Pastel de chocolate$8.00      1

        """.trimIndent().toByteArray()

        commands += byteArrayOf(0x1B, 0x61, 0x02) // Right
        commands += """
            Subtotal:         $22.50
            Impuestos:        $2.25
            Total:            $24.75

        """.trimIndent().toByteArray()

        commands += byteArrayOf(0x1B, 0x61, 0x01) // Center again
        commands += "¡Gracias por su compra!\nVuelva pronto.\n".toByteArray()
        commands += byteArrayOf(0x1D, 0x56, 0x00) // Cut paper

        commands.forEach { outputStream?.write(it) }
        outputStream?.write(0x0A)
    } catch (e: Exception) {
        onError("Error al imprimir: ${e.message}")
    }
}

fun getPrintPreview(): String {
    return buildString {
        appendLine("           Mi Negocio")
        appendLine("Dirección: Calle Principal 123")
        appendLine("Teléfono: +123 456 789")
        appendLine("Fecha: ${org.confia.loanprintinvoice.utils.getCurrentDate()}")
        appendLine()
        appendLine("--------------------------------")
        appendLine("Producto          Precio   Cantidad")
        appendLine("--------------------------------")
        appendLine("Café americano    $5.00      2")
        appendLine("Té verde          $4.50      1")
        appendLine("Pastel de chocolate$8.00     1")
        appendLine()
        appendLine("                     Subtotal: $22.50")
        appendLine("                    Impuestos: $2.25")
        appendLine("                        Total: $24.75")
        appendLine()
        appendLine("       ¡Gracias por su compra!")
        appendLine("           Vuelva pronto.")
    }
}
