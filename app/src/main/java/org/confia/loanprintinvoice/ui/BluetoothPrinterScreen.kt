package org.confia.loanprintinvoice.ui

import android.Manifest
import android.bluetooth.BluetoothDevice
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.confia.loanprintinvoice.bluetooth.loadPairedDevices
import org.confia.loanprintinvoice.bluetooth.requestPermissions
import org.confia.loanprintinvoice.printer.connectToPrinter
import org.confia.loanprintinvoice.printer.disconnectPrinter
import org.confia.loanprintinvoice.printer.getPrintPreview
import org.confia.loanprintinvoice.printer.printReceipt

@Composable
@RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
fun BluetoothPrinterScreen() {
    var pairedDevices by remember { mutableStateOf<List<BluetoothDevice>>(emptyList()) }
    var filteredDevices by remember { mutableStateOf<List<BluetoothDevice>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isConnected by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var isPrinting by remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (permissions.all { it.value }) {
            loadPairedDevices { devices, error ->
                errorMessage = error
                pairedDevices = devices
                filteredDevices = devices.filter { it.name == "MPT-II" }

                if (filteredDevices.size == 1) {
                    // Conexión automática
                    connectToPrinter(filteredDevices.first().address) { error ->
                        errorMessage = error
                        isConnected = error == null
                    }
                }
            }
        } else {
            errorMessage = "Los permisos necesarios no fueron otorgados."
        }
    }

    LaunchedEffect(Unit) {
        requestPermissions(permissionLauncher)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Dispositivos Bluetooth 'MPT-II'", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        when {
            filteredDevices.isEmpty() -> {
                Text("No se encontraron dispositivos MPT-II.")
            }

            filteredDevices.size > 1 -> {
                LazyColumn {
                    items(filteredDevices) { device ->
                        Button(onClick = {
                            connectToPrinter(device.address) { error ->
                                errorMessage = error
                                isConnected = error == null
                            }
                        }) {
                            Text("Conectar a: ${device.name} - ${device.address}")
                        }
                        Spacer(Modifier.height(8.dp))
                    }
                }
            }

            // Si ya hay uno conectado automáticamente, no mostramos nada aquí
        }

        if (isConnected) {
            Spacer(Modifier.height(16.dp))

            Text("Vista previa de impresión:", style = MaterialTheme.typography.titleMedium)
            Text(
                getPrintPreview(),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Button(
                onClick = {
                    coroutineScope.launch {
                        isPrinting = true
                        printReceipt { errorMessage = it }
                        isPrinting = false
                    }
                },
                enabled = !isPrinting
            ) {
                Text(if (isPrinting) "Imprimiendo..." else "Imprimir texto")
            }

            Spacer(Modifier.height(8.dp))

            Button(onClick = {
                disconnectPrinter()
                isConnected = false
            }) {
                Text("Desconectar")
            }
        }

        Spacer(Modifier.height(16.dp))
        errorMessage?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
        }
    }
}
