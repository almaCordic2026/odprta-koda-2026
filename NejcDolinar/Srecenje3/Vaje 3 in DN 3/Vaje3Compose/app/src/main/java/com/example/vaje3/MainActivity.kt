package com.example.vaje3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vaje3.ui.theme.Vaje3Theme
import com.example.vaje3.vaje.IgraKlikerScreen
import com.example.vaje3.vaje.JedilniListScreen
import com.example.vaje3.vaje.KalkulatorNaprednejsiScreen
import com.example.vaje3.vaje.KalkulatorNaprednejsiZgodovinaScreen
import com.example.vaje3.vaje.KalkulatorScreen
import com.example.vaje3.vaje.KlikerScreen
import com.example.vaje3.vaje.UrnikScreen
import com.example.vaje3.vaje.VizitkaScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vaje3Theme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    var izbranaVaja by remember { mutableStateOf<Int?>(null) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            when (izbranaVaja) {
                1 -> VizitkaScreen()
                2 -> JedilniListScreen()
                3 -> UrnikScreen()
                4 -> KalkulatorScreen()
                5 -> KalkulatorNaprednejsiScreen()
                6 -> KalkulatorNaprednejsiZgodovinaScreen()
                7 -> KlikerScreen()
                8 -> IgraKlikerScreen()
                else -> MeniScreen(onIzbira = { izbranaVaja = it })
            }
            if (izbranaVaja != null) {
                FloatingActionButton(
                    onClick = { izbranaVaja = null },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                ) {
                    Text("←")
                }
            }
        }
    }
}

@Composable
fun MeniScreen(onIzbira: (Int) -> Unit) {
    val vaje = listOf(
        1 to "Osebna vizitka",
        2 to "Jedilni list",
        3 to "Šolski urnik",
        4 to "Kalkulator",
        5 to "Kalkulator napredni",
        6 to "Kalkulator napredni II (zgodovina)",
        7 to "Kliker",
        8 to "Igra kliker"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Vaje 3 — Compose",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        vaje.forEach { (st, ime) ->
            Button(
                onClick = { onIzbira(st) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("$st. $ime")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MeniScreenPreview() {
    Vaje3Theme {
        MeniScreen(onIzbira = {})
    }
}
