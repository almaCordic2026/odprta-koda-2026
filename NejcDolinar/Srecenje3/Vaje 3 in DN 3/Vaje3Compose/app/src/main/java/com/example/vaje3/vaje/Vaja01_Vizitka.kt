package com.example.vaje3.vaje

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import com.example.vaje3.ui.theme.Vaje3Theme

/**
 * Vaja 1: Osebna vizitka
 * - Column z elementi eden pod drugim
 * - Različne velikosti pisave (fontSize)
 * - Druga barva besedila za "Šola / podjetje"
 * - Svetlo ozadje (background)
 * - horizontalAlignment.CenterHorizontally
 */
@Composable
fun VizitkaScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD))   // svetla barva ozadja
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Ime in priimek - večji tekst
        Text(
            text = "Nejc Dolinar",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1565C0)
        )

        // Poklic / vloga - manjši tekst
        Text(
            text = "Učenec",
            fontSize = 18.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Šola / podjetje - druga barva
        Text(
            text = "Alma mater Europea",
            fontSize = 20.sp,
            color = Color(0xFF2E7D32)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // E-pošta na dnu kartice
        Text(
            text = "nejc.dolinar@almamater.si",
            fontSize = 16.sp,
            color = Color.DarkGray
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VizitkaPreview() {
    Vaje3Theme {
        VizitkaScreen()
    }
}
