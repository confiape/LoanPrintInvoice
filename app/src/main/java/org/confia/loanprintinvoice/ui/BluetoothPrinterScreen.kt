package org.confia.loanprintinvoice.ui

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
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
import org.confia.loanprintinvoice.models.PaymentDetailsResponseDto
import org.confia.loanprintinvoice.network.RetrofitInstance
import org.confia.loanprintinvoice.printer.connectToPrinter
import org.confia.loanprintinvoice.printer.disconnectPrinter
import org.confia.loanprintinvoice.printer.getPaymentReceiptPreview
import org.confia.loanprintinvoice.printer.printPaymentReceipt
import java.util.UUID

import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.compose.ui.platform.LocalContext

@SuppressLint("ContextCastToActivity")
@Composable
@RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
fun BluetoothPrinterScreen(paymentId: UUID?, token: String?,returnHost: String?) {
    LaunchedEffect(token) {
        RetrofitInstance.setAuthToken(token)
    }
    var pairedDevices by remember { mutableStateOf<List<BluetoothDevice>>(emptyList()) }
    var filteredDevices by remember { mutableStateOf<List<BluetoothDevice>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isConnected by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var isPrinting by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val activity = (LocalContext.current as? Activity)
    var paymentDetails by remember { mutableStateOf<PaymentDetailsResponseDto?>(null) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (permissions.all { it.value }) {
            loadPairedDevices { devices, error ->
                errorMessage = error
                pairedDevices = devices
                filteredDevices = devices.filter { it.name == "MPT-II" }

                if (filteredDevices.size == 1) {
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

        if (paymentId != null) {
            coroutineScope.launch {
                val response = RetrofitInstance.api.getPaymentDetail(paymentId)
                if (response.isSuccessful) {
                    paymentDetails = response.body()
                } else {
                    errorMessage = "Error al cargar detalles del pago" + response.message()
                }
            }
        } else {
            errorMessage = "No se proporcionó un paymentId válido"
        }
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
        }

        if (isConnected) {
            Spacer(Modifier.height(16.dp))

            Text("Vista previa de impresión:", style = MaterialTheme.typography.titleMedium)


            paymentDetails?.let { payment ->
                Button(
                    onClick = {
                        coroutineScope.launch {
                            isPrinting = true
                            printPaymentReceipt(payment) { errorMessage = it }
                            isPrinting = false
                        }
                    },
                    enabled = !isPrinting
                ) {
                    Text(if (isPrinting) "Imprimiendo..." else "Imprimir Recibo")
                }

                Spacer(Modifier.height(16.dp))

                Text("Vista previa del recibo:")
                Text(getPaymentReceiptPreview(payment))
            }

            Spacer(Modifier.height(8.dp))

            Button(onClick = {
                activity?.finish()
            }) {
                Text("Regresar a la aplicación")
            }
        }

        Spacer(Modifier.height(16.dp))
        errorMessage?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
        }
    }
}
