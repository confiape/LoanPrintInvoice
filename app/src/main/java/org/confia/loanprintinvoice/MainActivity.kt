package org.confia.loanprintinvoice

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.confia.loanprintinvoice.ui.BluetoothPrinterScreen
import org.confia.loanprintinvoice.ui.theme.LoanPrintInvoiceTheme
import org.json.JSONObject
import java.util.UUID

class MainActivity : ComponentActivity() {
    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val data = intent?.data
        var token: String? = null
        var paymentId: UUID? = null
        var returnHost: String? = null

        data?.getQueryParameter("json")?.let { jsonEncoded ->
            try {
                val json = JSONObject(jsonEncoded)
                token = json.optString("token", null)
                paymentId = json.optString("id")?.let { UUID.fromString(it) }
                returnHost = json.optString("host", null)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        setContent {
            LoanPrintInvoiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        paymentId = paymentId, token = token, returnHost = returnHost,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
@Composable
fun Greeting(paymentId: UUID?, token: String?,returnHost: String?, modifier: Modifier = Modifier) {
    BluetoothPrinterScreen(  paymentId = paymentId, token = token,returnHost = returnHost,)
}

