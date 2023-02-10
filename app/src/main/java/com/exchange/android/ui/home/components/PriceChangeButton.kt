package com.exchange.android.ui.home.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.exchange.android.R
import com.exchange.android.extentions.toFormattedString
import com.exchange.android.ui.theme.AppTheme
import kotlin.math.abs

@Composable
fun PriceChangeButton(
    modifier: Modifier,
    priceChangePercent: Double,
    displayForDetailPage: Boolean = false,
) {
    val isPositiveNumber = priceChangePercent >= 0

    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (displayForDetailPage)
                AppTheme.colors.priceChangeButtonBackgroundInDetail else AppTheme.colors.priceChangeButtonBackground,
            contentColor = if (isPositiveNumber)
                AppTheme.colors.priceTextPositive else AppTheme.colors.priceTextNegative
        ),
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(start = 13.dp, end = 8.dp),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 0.dp),
        onClick = { /* TODO */ },
    ) {
        Icon(
            modifier = Modifier
                .padding(end = if (displayForDetailPage) 9.dp else 13.dp)
                .align(alignment = Alignment.CenterVertically),
            painter = if (isPositiveNumber) {
                painterResource(id = R.drawable.ic_guppie_green_arrow_up)
            } else {
                painterResource(id = R.drawable.ic_fire_opal_arrow_down)
            },
            contentDescription = null
        )

        Text(
            text = stringResource(
                R.string.coin_profit_percent,
                abs(priceChangePercent).toFormattedString()
            ),
            style = AppTheme.styles.medium16
        )
    }
}


