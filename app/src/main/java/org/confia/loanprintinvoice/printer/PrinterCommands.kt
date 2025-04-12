package org.confia.loanprintinvoice.printer

import android.graphics.Bitmap
import org.confia.loanprintinvoice.models.PaymentDetailsResponseDto
import org.confia.loanprintinvoice.utils.formatOffsetDateTime
import java.io.ByteArrayOutputStream
import java.time.OffsetDateTime
import kotlin.experimental.or

fun printPaymentReceipt(payment: PaymentDetailsResponseDto, onError: (String) -> Unit) {
    try {
        val qrJson = """
{
  "name": "${payment.name}",
  "dni": "${payment.dni}",
  "amount": ${payment.paymentAmount},
  "date": "${payment.paymentDate}"
}
""".trimIndent()

        val lines = getPaymentReceiptPreview(payment).split("\n")
        outputStream?.write(byteArrayOf(0x1B, 0x40)) // Reset

        for (line in lines) {
            outputStream?.write(line.toByteArray())
            outputStream?.write(byteArrayOf(0x0A)) // salto de línea
        }
        outputStream?.write(escPosQrCode(qrJson))
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

fun bitmapToEscPos(bitmap: Bitmap): ByteArray {
    val stream = ByteArrayOutputStream()
    val width = bitmap.width
    val height = bitmap.height
    val bytes = mutableListOf<Byte>()

    for (y in 0 until height step 24) {
        bytes.add(0x1B)
        bytes.add(0x2A)
        bytes.add(33) // mode: 24-dot double-density
        bytes.add((width % 256).toByte())
        bytes.add((width / 256).toByte())

        for (x in 0 until width) {
            for (k in 0 until 3) {
                var slice: Byte = 0
                for (b in 0 until 8) {
                    val yIndex = y + k * 8 + b
                    if (yIndex >= height) continue
                    val pixel = bitmap.getPixel(x, yIndex)
                    val r = (pixel shr 16) and 0xff
                    val g = (pixel shr 8) and 0xff
                    val bColor = pixel and 0xff
                    val luminance = 0.299 * r + 0.587 * g + 0.114 * bColor
                    if (luminance < 127) {
                        slice = (slice or ((1 shl (7 - b)).toByte())).toByte()
                    }
                }
                bytes.add(slice)
            }
        }
        bytes.add(0x0A) // newline
    }

    return bytes.toByteArray()
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
        0x30
    ) // Nivel de corrección (48 = L, 49 = M, etc)

    val dataBytes = data.toByteArray(charset)
    val pL = (dataBytes.size + 3) % 256
    val pH = (dataBytes.size + 3) / 256

    val storeCommand =
        byteArrayOf(0x1D, 0x28, 0x6B, pL.toByte(), pH.toByte(), 0x31, 0x50, 0x30) + dataBytes
    val printCommand = byteArrayOf(0x1D, 0x28, 0x6B, 0x03, 0x00, 0x31, 0x51, 0x30)

    return modelCommand + sizeCommand + errorCommand + storeCommand + printCommand
}