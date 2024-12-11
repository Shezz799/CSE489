package com.example.broadcastdemo.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColors = lightColorScheme(
    primary = Color(0xFFFF4AAE),
    secondary = Color(0xFFAED9E0),
    tertiary = Color(0xFFFAF3DD),
    background = Color(0xFFFFFBF7),
    surface = Color(0xFFFFFBF7),
    onPrimary = Color.White,
    onSecondary = Color(0xFF1B1B1B),
    onTertiary = Color(0xFF1B1B1B),
    onBackground = Color(0xFF1B1B1B),
    onSurface = Color(0xFF1B1B1B),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFFF4AAE),
    secondary = Color(0xFFAED9E0),
    tertiary = Color(0xFFFAF3DD),
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    onPrimary = Color(0xFF1B1B1B),
    onSecondary = Color(0xFF1B1B1B),
    onTertiary = Color(0xFF1B1B1B),
    onBackground = Color.White,
    onSurface = Color.White,
)

@Composable
fun BroadcastDemoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors
    val view = LocalView.current
    
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
