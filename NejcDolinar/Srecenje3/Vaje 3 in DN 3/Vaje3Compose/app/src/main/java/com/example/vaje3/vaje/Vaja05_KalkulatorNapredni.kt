package com.example.vaje3.vaje

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vaje3.ui.theme.Vaje3Theme

/**
 * Vaja 5: Kalkulator napredni
 * - Dva vnosa za števili (Prvo število, Drugo število)
 * - Vrstica s petimi gumbi za operacije: + - * / %
 * - Klik na gumb takoj izvede operacijo in pokaže rezultat
 */
@Composable
fun KalkulatorNaprednejsiScreen(modifier: Modifier = Modifier) {
    var prvo by remember { mutableStateOf("") }
    var drugo by remember { mutableStateOf("") }
    var rezultat by remember { mutableStateOf("") }

    fun izracunaj(operator: String) {
        val a = prvo.toDoubleOrNull()
        val b = drugo.toDoubleOrNull()
        if (a == null || b == null) {
            rezultat = "Napaka: vnesi števili"
            return
        }
        rezultat = when (operator) {
            "+" -> formatStevilo(a + b)
            "-" -> formatStevilo(a - b)
            "*" -> formatStevilo(a * b)
            "/" -> if (b == 0.0) "Napaka: deljenje z 0" else formatStevilo(a / b)
            "%" -> if (b == 0.0) "Napaka: deljenje z 0" else formatStevilo(a % b)
            else -> ""
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = prvo,
            onValueChange = { prvo = it },
            label = { Text("Prvo število") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = drugo,
            onValueChange = { drugo = it },
            label = { Text("Drugo število") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Vrstica s petimi gumbi - vsak gumb enakomerno zavzame prostor (weight)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            listOf("+", "-", "*", "/", "%").forEach { op ->
                Button(
                    onClick = { izracunaj(op) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(op, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Rezultat:",
            fontSize = 14.sp
        )
        Text(
            text = rezultat,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/** Če je rezultat celo število, ga prikaže brez decimalk; sicer dve decimalki. */
private fun formatStevilo(r: Double): String {
    return if (r == r.toLong().toDouble()) r.toLong().toString()
    else "%.2f".format(r)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KalkulatorNaprednejsiPreview() {
    Vaje3Theme {
        KalkulatorNaprednejsiScreen()
    }
}
