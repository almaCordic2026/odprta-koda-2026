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
 * Vaja 3: Šolski urnik
 * - Temno ozadje, svetlo besedilo
 * - Column + 4 Row-i z uro in predmetom
 * - fillMaxSize + fillMaxWidth
 */
@Composable
fun UrnikScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF263238))       // temno modro-sivo ozadje
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Moj urnik",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(32.dp))

        UrnikVrstica(ura = "08:00", predmet = "Matematika")
        UrnikVrstica(ura = "09:00", predmet = "Slovenščina")
        UrnikVrstica(ura = "10:00", predmet = "Računalništvo")
        UrnikVrstica(ura = "11:00", predmet = "Angleščina")
    }
}

@Composable
private fun UrnikVrstica(ura: String, predmet: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = ura,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFEE58)        // rumena za uro
        )
        Text(
            text = predmet,
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UrnikPreview() {
    Vaje3Theme {
        UrnikScreen()
    }
}
