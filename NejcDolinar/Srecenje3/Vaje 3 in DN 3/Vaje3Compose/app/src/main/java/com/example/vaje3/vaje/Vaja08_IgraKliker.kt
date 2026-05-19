package com.example.vaje3.vaje

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vaje3.ui.theme.Vaje3Theme

/**
 * Vaja 8: Igra kliker
 * - Dva gumba (rdeč +1, moder -1) — vsak zavzame pol ekrana
 * - Vnosno polje samo za branje, prikazuje trenutno število
 * - Zmagovalec, ki prvi preseže ±20 točk:
 *     • >= 20  → zmaga RDEČI
 *     • <= -20 → zmaga MODRI
 * - Po zmagi se prikaže rezultat in gumb za novo igro
 */
@Composable
fun IgraKlikerScreen(modifier: Modifier = Modifier) {
    var stevec by remember { mutableIntStateOf(0) }
    var zmagovalec by remember { mutableStateOf<String?>(null) }
    var barvaZmagovalca by remember { mutableStateOf(Color.Black) }

    fun resetiraj() {
        stevec = 0
        zmagovalec = null
        barvaZmagovalca = Color.Black
    }

    fun povecaj() {
        if (zmagovalec != null) return
        stevec++
        if (stevec >= 20) {
            zmagovalec = "RDEČI"
            barvaZmagovalca = Color(0xFFD32F2F)
        }
    }

    fun zmanjsaj() {
        if (zmagovalec != null) return
        stevec--
        if (stevec <= -20) {
            zmagovalec = "MODRI"
            barvaZmagovalca = Color(0xFF1976D2)
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        if (zmagovalec == null) {
            // Zgornji del - prikaz trenutnega rezultata (read-only "vnosno polje")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stevec.toString(),
                    fontSize = 72.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Spodnji del - dva velika gumba, vsak po pol širine
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { zmanjsaj() },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1976D2)
                    ),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(
                        text = "−",
                        fontSize = 96.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { povecaj() },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFD32F2F)
                    ),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(
                        text = "+",
                        fontSize = 96.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        } else {
            // Zaslon zmagovalca
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(barvaZmagovalca)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Zmagal je",
                    fontSize = 36.sp,
                    color = Color.White
                )
                Text(
                    text = zmagovalec!!,
                    fontSize = 72.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "(rezultat: $stevec)",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Button(
                    onClick = { resetiraj() },
                    modifier = Modifier.padding(top = 32.dp)
                ) {
                    Text("Nova igra")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IgraKlikerPreview() {
    Vaje3Theme {
        IgraKlikerScreen()
    }
}
