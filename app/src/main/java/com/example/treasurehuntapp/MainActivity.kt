package com.example.treasurehuntapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.example.treasurehuntapp.ui.theme.TreasureHuntTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreasureHuntTheme {
                // Navegação do aplicativo
                TreasureHuntNavHost()
            }
        }
    }
}

@Composable
fun TreasureHuntNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("pista1") { PistaScreen(navController, 1) }
        composable("pista2") { PistaScreen(navController, 2) }
        composable("pista3") { PistaScreen(navController, 3) }
        composable("tesouro") { TreasureScreen(navController) }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Surface {
        Button(onClick = { navController.navigate("pista1") }) {
            Text("Iniciar Caça ao Tesouro")
        }
    }
}

@Composable
fun PistaScreen(navController: NavController, pistaNumber: Int) {
    Surface {
        Column {
            Text(text = "Pista $pistaNumber: Resolva o enigma para prosseguir!")
            Row {
                Button(onClick = { navController.navigate("pista${pistaNumber + 1}") }) {
                    Text("Próxima Pista")
                }
                Button(onClick = { navController.popBackStack() }) {
                    Text("Voltar")
                }
            }
        }
    }
}

@Composable
fun TreasureScreen(navController: NavController) {
    Surface {
        Column {
            Text("Parabéns! Você encontrou o tesouro!")
            Button(onClick = { navController.navigate("home") }) {
                Text("Recomeçar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TreasureHuntTheme {
        HomeScreen(rememberNavController())
    }
}
