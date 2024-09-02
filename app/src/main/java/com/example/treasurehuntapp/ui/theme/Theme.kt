package com.example.treasurehuntapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Definição de cores
private val DarkColorPalette = darkColorScheme(
    primary = Color(0xFFBB86FC),
    primaryContainer = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC6)
)

private val LightColorPalette = lightColorScheme(
    primary = Color(0xFF6200EE),
    primaryContainer = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC6)
)

@Composable
fun TreasureHuntTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
