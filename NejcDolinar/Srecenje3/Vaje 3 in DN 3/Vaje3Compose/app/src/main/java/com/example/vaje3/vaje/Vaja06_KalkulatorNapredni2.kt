package com.example.vaje3.vaje

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vaje3.ui.theme.Vaje3Theme

/**
 * Vaja 6: Kalkulator napredni II
 * Razširjena različica vaje 5 — z zgodovino računov.
 * Vsak izračun se shrani v seznam (do 10 zadnjih) in se prikaže pod kalkulatorjem.
 *
 * Ključni koncepti:
 * - mutableStateListOf za reaktivno hranjenje seznama
 * - verticalScroll za drsenje vsebine, ko je veliko zgodovine
 */
@Composable
fun KalkulatorNaprednejsiZgodovinaScreen(modifier: Modifier = Modifier) {
    var prvo by remember { mutableStateOf("") }
    var drugo by remember { mutableStateOf("") }
    var rezultat by remember { mutableStateOf("") }
    val zgodovina = remember { mutableStateListOf<String>() }

    fun izracunaj(operator: String) {
        val a = prvo.toDoubleOrNull()
        val b = drugo.toDoubleOrNull()
        if (a == null || b == null) {
            rezultat = "Napaka: vnesi števili"
            return
        }
        val r: String = when (operator) {
            "+" -> formatStevilo2(a + b)
            "-" -> formatStevilo2(a - b)
            "*" -> formatStevilo2(a * b)
            "/" -> if (b == 0.0) "Napaka" else formatStevilo2(a / b)
            "%" -> if (b == 0.0) "Napaka" else formatStevilo2(a % b)
            else -> ""
        }
        rezultat = r
        // dodaj v zgodovino, drži največ 10 zapisov
        zgodovina.add(0, "${formatStevilo2(a)} $operator ${formatStevilo2(b)} = $r")
        if (zgodovina.size > 10) zgodovina.removeAt(zgodovina.size - 1)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Kalkulator z zgodovino",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(top = 12.dp))

        OutlinedTextField(
            value = prvo,
            onValueChange = { prvo = it },
            label = { Text("Prvo število") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))

        OutlinedTextField(
            value = drugo,
            onValueChange = { drugo = it },
            label = { Text("Drugo število") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.padding(top = 16.dp))

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

        Spacer(modifier = Modifier.padding(top = 16.dp))
        Text(text = "Rezultat:", fontSize = 14.sp)
        Text(
            text = rezultat,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(top = 24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Zgodovina",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            if (zgodovina.isNotEmpty()) {
                TextButton(onClick = { zgodovina.clear() }) {
                    Text("Počisti")
                }
            }
        }

        if (zgodovina.isEmpty()) {
            Text(
                text = "(še ni izračunov)",
                color = Color.Gray,
                fontSize = 14.sp
            )
        } else {
            zgodovina.forEach { zapis ->
                Text(
                    text = zapis,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .background(
                            color = Color(0xFFEEEEEE),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .padding(8.dp)
                )
            }
        }
    }
}

private fun formatStevilo2(r: Double): String {
    return if (r == r.toLong().toDouble()) r.toLong().toString()
    else "%.2f".format(r)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KalkulatorNaprednejsiZgodovinaPreview() {
    Vaje3Theme {
        KalkulatorNaprednejsiZgodovinaScreen()
    }
}
