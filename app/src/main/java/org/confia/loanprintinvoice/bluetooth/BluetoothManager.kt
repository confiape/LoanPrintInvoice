package org.confia.loanprintinvoice.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.Manifest
import androidx.annotation.RequiresPermission

@RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
fun loadPairedDevices(onResult: (List<BluetoothDevice>, String?) -> Unit) {
    val adapter = BluetoothAdapter.getDefaultAdapter()

    when {
        adapter == null -> onResult(emptyList(), "Bluetooth no disponible.")
        !adapter.isEnabled -> onResult(emptyList(), "Bluetooth desactivado.")
        else -> {
            val paired = adapter.bondedDevices
            onResult(paired.toList(), if (paired.isEmpty()) "No hay dispositivos vinculados." else null)
        }
    }
}
