package org.confia.loanprintinvoice.printer

import org.confia.loanprintinvoice.models.PaymentDetailsResponseDto
import org.confia.loanprintinvoice.utils.formatOffsetDateTime
import java.time.OffsetDateTime

fun printPaymentReceipt(payment: PaymentDetailsResponseDto, onError: (String) -> Unit) {
    try {

        val lines = getPaymentReceiptPreview(payment).split("\n")
        outputStream?.write(byteArrayOf(0x1B, 0x40))

        for (line in lines) {
            outputStream?.write(line.toByteArray())
            outputStream?.write(byteArrayOf(0x0A))
        }
        outputStream?.write(escPosQrCode(payment.url))
        outputStream?.write(byteArrayOf(0x0A))
    } catch (e: Exception) {
        onError("Error al imprimir recibo: ${e.message}")
    }
}

fun getPaymentReceiptPreview(payment: PaymentDetailsResponseDto): String {
    return buildString {
        appendLine("         RECIBO DE PAGO")
        appendLine("Fecha: ${formatOffsetDateTime(payment.paymentDate)}")
        appendLine(formatReceiptNumber(payment.paymentNumber, payment.paymentDate))
        appendLine("--------------------------------")
        appendLine("Nombre          : ${payment.name}")
        appendLine("DNI             : ${payment.dni}")
        appendLine("--------------------------------")
        appendLine("Monto Prestamo  : $${payment.loanAmount}")
        appendLine("Monto Pagado    : $${payment.paymentAmount}")
        appendLine("--------------------------------")
        appendLine("Gracias por su pago.")
    }
}

fun formatReceiptNumber(paymentNumber: Int, date: OffsetDateTime): String {
    return "No Recibo: %06d-%d".format(paymentNumber, date.year)
}


fun escPosQrCode(data: String): ByteArray {
    val charset = Charsets.UTF_8

    val modelCommand = byteArrayOf(0x1D, 0x28, 0x6B, 0x04, 0x00, 0x31, 0x41, 0x32, 0x00)
    val sizeCommand = byteArrayOf(0x1D, 0x28, 0x6B, 0x03, 0x00, 0x31, 0x43, 0x06) // Tamaño QR 1-16
    val errorCommand = byteArrayOf(
        0x1D,
        0x28,
        0x6B,
        0x03,
        0x00,
        0x31,
        0x45,
        0x33
    )

    val dataBytes = data.toByteArray(charset)
    val pL = (dataBytes.size + 3) % 256
    val pH = (dataBytes.size + 3) / 256

    val storeCommand =
        byteArrayOf(0x1D, 0x28, 0x6B, pL.toByte(), pH.toByte(), 0x31, 0x50, 0x30) + dataBytes
    val printCommand = byteArrayOf(0x1D, 0x28, 0x6B, 0x03, 0x00, 0x31, 0x51, 0x30)

    return modelCommand + sizeCommand + errorCommand + storeCommand + printCommand
}