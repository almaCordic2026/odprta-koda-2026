package com.example.vaje3.vaje

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.vaje3.ui.theme.Vaje3Theme
import androidx.compose.ui.unit.dp
/**
 * Vaja 7: Kliker
 * - Celoten zaslon je en gumb
 * - Na gumbu je prikazano število, ki se začne pri 0
 * - Vsak klik poveča število za 1
 * - Število je centrirano
 *
 * Uporaba mutableIntStateOf je optimizirana za Int (manj boxinga kot mutableStateOf<Int>).
 */
@Composable
fun KlikerScreen(modifier: Modifier = Modifier) {
    var stevec by remember { mutableIntStateOf(0) }

    Button(
        onClick = { stevec++ },
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(0.dp)   // brez zaobljenih robov - gumb pokrije ves zaslon
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stevec.toString(),
                fontSize = 96.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KlikerPreview() {
    Vaje3Theme {
        KlikerScreen()
    }
}
