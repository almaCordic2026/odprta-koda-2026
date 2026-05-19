package com.example.vaje3.vaje

import androidx.compose.foundation.layout.Column
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
 * Vaja 4: Kalkulator (osnoven)
 * - Dva vnosa za števili
 * - Gumb "Seštej" izračuna vsoto
 * - Rezultat se prikaže v read-only polju
 *
 * Ključni koncepti:
 * - State management z remember + mutableStateOf
 * - OutlinedTextField za vnos
 * - KeyboardType.Number za številčno tipkovnico
 * - toIntOrNull() za varno pretvorbo Stringa v Int
 */
@Composable
fun KalkulatorScreen(modifier: Modifier = Modifier) {
    var stevilo1 by remember { mutableStateOf("") }
    var stevilo2 by remember { mutableStateOf("") }
    var rezultat by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Naslov",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Stevilo 1:", fontSize = 14.sp)
        OutlinedTextField(
            value = stevilo1,
            onValueChange = { stevilo1 = it },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Stevilo 2:", fontSize = 14.sp)
        OutlinedTextField(
            value = stevilo2,
            onValueChange = { stevilo2 = it },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val a = stevilo1.toIntOrNull() ?: 0
                val b = stevilo2.toIntOrNull() ?: 0
                rezultat = (a + b).toString()
            }
        ) {
            Text("Seštej")
        }
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = rezultat,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KalkulatorPreview() {
    Vaje3Theme {
        KalkulatorScreen()
    }
}
