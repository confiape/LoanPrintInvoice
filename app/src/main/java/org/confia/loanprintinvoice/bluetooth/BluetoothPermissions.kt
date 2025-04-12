package org.confia.loanprintinvoice.bluetooth

import android.Manifest
import android.os.Build
import androidx.activity.compose.ManagedActivityResultLauncher

fun requestPermissions(permissionLauncher: ManagedActivityResultLauncher<Array<String>, Map<String, Boolean>>) {
    val permissions = mutableListOf(Manifest.permission.ACCESS_FINE_LOCATION)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        permissions += listOf(
            Manifest.permission.BLUETOOTH_SCAN,
            Manifest.permission.BLUETOOTH_CONNECT
        )
    }

    permissionLauncher.launch(permissions.toTypedArray())
}
