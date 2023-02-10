package com.exchange.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable


@Composable
fun ExchangeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val styles = LocalAppStyles.current

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalAppStyles provides styles
    ) {
        MaterialTheme(
            colors = colors.themeColors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object AppTheme {

    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.shapes

    val styles: AppStyles
        @Composable
        @ReadOnlyComposable
        get() = LocalAppStyles.current
}
