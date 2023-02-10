package com.exchange.android.ui.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
fun PriceChange(
    priceChangePercentage24hInCurrency: Double,
    modifier: Modifier,
    displayForDetailPage: Boolean = false
) {
    val isPositiveNumber = priceChangePercentage24hInCurrency >= 0

    Row(modifier = modifier) {
        Icon(
            modifier = Modifier
                .padding(end = if (displayForDetailPage) 9.dp else 13.dp)
                .align(alignment = Alignment.CenterVertically),
            painter = if (isPositiveNumber) {
                painterResource(id = R.drawable.ic_guppie_green_arrow_up)
            } else {
                painterResource(id = R.drawable.ic_fire_opal_arrow_down)
            },
            tint = if (isPositiveNumber) AppTheme.colors.priceTextPositive else AppTheme.colors.priceTextNegative,
            contentDescription = null
        )

        Text(
            text = stringResource(
                R.string.coin_profit_percent,
                abs(priceChangePercentage24hInCurrency).toFormattedString()
            ),
            style = if (displayForDetailPage) AppTheme.styles.medium14 else AppTheme.styles.medium16,
            color = if (isPositiveNumber) AppTheme.colors.priceTextPositive else AppTheme.colors.priceTextNegative
        )
    }
}

