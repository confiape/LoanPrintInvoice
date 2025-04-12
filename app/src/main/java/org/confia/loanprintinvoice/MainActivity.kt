package org.confia.loanprintinvoice

import android.Manifest
import android.os.Bundle
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

class MainActivity : ComponentActivity() {
    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoanPrintInvoiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    BluetoothPrinterScreen()
}

@Preview(showBackground = true)
@Composable
@RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
fun GreetingPreview() {
    LoanPrintInvoiceTheme {
        Greeting("Android")
    }
}