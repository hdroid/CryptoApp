package com.exchange.android.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.sp
import com.exchange.android.R

class AppStyles {

    private val textStyle = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.inter_medium, FontWeight.Medium),
            Font(R.font.inter_semi_bold, FontWeight.SemiBold)
        )
    )

    val medium12: TextStyle
        @Composable
        get() = textStyle.copy(fontWeight = FontWeight.Medium, fontSize = 12.sp)

    val medium14: TextStyle
        @Composable
        get() = textStyle.copy(fontWeight = FontWeight.Medium, fontSize = 14.sp)

    val tiffanyBlueMedium14: TextStyle
        @Composable
        get() = medium14.copy(color = TiffanyBlue)

    val medium16: TextStyle
        @Composable
        get() = textStyle.copy(fontWeight = FontWeight.Medium, fontSize = 16.sp)

    val lightSilverMedium16: TextStyle
        @Composable
        get() = medium16.copy(color = LightSilver)

    val semiBold16: TextStyle
        @Composable
        get() = textStyle.copy(fontWeight = FontWeight.SemiBold, fontSize = 16.sp)

    val semiBold24: TextStyle
        @Composable
        get() = textStyle.copy(fontWeight = FontWeight.SemiBold, fontSize = 24.sp)

    val whiteSemiBold24: TextStyle
        @Composable
        get() = semiBold24.copy(color = White)
}

internal val LocalAppStyles = staticCompositionLocalOf { AppStyles() }
