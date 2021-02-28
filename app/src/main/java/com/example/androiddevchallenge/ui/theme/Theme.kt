package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    onPrimary = White,
    secondary = Black,
    onSecondary = White,
    background = Black,
    onBackground = White,
    surface = Black1,
    onSurface = White
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    onPrimary = Black,
    secondary = White,
    onSecondary = Black,
    background = Grey,
    onBackground = Black1,
    surface = White,
    onSurface = Black
)

@Composable
fun AndroidDevChallengeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}