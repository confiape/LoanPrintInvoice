package org.confia.loanprintinvoice.printer

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.Manifest
import androidx.annotation.RequiresPermission
import java.io.OutputStream
import java.util.*

private var bluetoothSocket: BluetoothSocket? = null
var outputStream: OutputStream? = null

@RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
fun connectToPrinter(mac: String, onError: (String?) -> Unit) {
    val adapter = BluetoothAdapter.getDefaultAdapter()
    val device: BluetoothDevice? = adapter?.getRemoteDevice(mac)

    try {
        bluetoothSocket = device?.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"))
        bluetoothSocket?.connect()
        outputStream = bluetoothSocket?.outputStream
        onError(null)
    } catch (e: Exception) {
        onError("Error al conectar: ${e.message}")
        disconnectPrinter()
    }
}

fun disconnectPrinter() {
    try {
        outputStream?.close()
        bluetoothSocket?.close()
    } catch (_: Exception) {}
}
