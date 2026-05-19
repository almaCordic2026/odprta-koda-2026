package com.example.vaje3.vaje

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vaje3.ui.theme.Vaje3Theme

/**
 * Vaja 2: Jedilni list
 * - Column za celoten zaslon
 * - Row za posamezno vrstico (ime jedi | cena)
 * - horizontalArrangement.SpaceBetween potisne ceno na desno
 * - Različne barve besedila
 */
@Composable
fun JedilniListScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))     // svetlo rumeno ozadje
            .padding(24.dp)
    ) {
        Text(
            text = "Jedilni list",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6A1B1B)
        )
        Spacer(modifier = Modifier.height(24.dp))

        JedilnaVrstica(ime = "Goveja juha", cena = "3,50 €")
        JedilnaVrstica(ime = "Dunajski zrezek", cena = "9,90 €")
        JedilnaVrstica(ime = "Sladoled", cena = "4,20 €")
    }
}

@Composable
private fun JedilnaVrstica(ime: String, cena: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = ime,
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(
            text = cena,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFFB71C1C)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun JedilniListPreview() {
    Vaje3Theme {
        JedilniListScreen()
    }
}
