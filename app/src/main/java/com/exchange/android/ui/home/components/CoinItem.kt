package com.exchange.android.ui.home.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import com.exchange.android.domain.model.Coin
import com.exchange.android.ui.theme.AppTheme

const val TestTagTrendingItemSymbol = "TrendingItemSymbol"
const val TestTagTrendingItemCoinName = "TrendingItemCoinName"
const val TestTagTrendingItemPriceChange = "TrendingItemPriceChange"

@Suppress("LongMethod")
@Composable
fun CoinItem(
    modifier: Modifier = Modifier,
    coinItem: Coin,
    onItemClick: () -> Unit
) {

    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { onItemClick.invoke() }
            .background(color = AppTheme.colors.coinItemBackground)
            .padding(8.dp)
    ) {
        val (
            logo,
            coinSymbol,
            coinName,
            priceChange
        ) = createRefs()

        Image(
            modifier = Modifier
                .size(40.dp)
                .constrainAs(logo) {
                    linkTo(
                        top = parent.top,
                        bottom = parent.bottom,
                        topMargin = 6.dp,
                        bottomMargin = 6.dp
                    )
                    start.linkTo(parent.start)
                },
            painter = rememberAsyncImagePainter(coinItem.image),
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .constrainAs(coinSymbol) {
                    top.linkTo(parent.top)
                    bottom.linkTo(coinName.top)
                    start.linkTo(anchor = logo.end, margin = 16.dp)
                }
                .testTag(tag = TestTagTrendingItemSymbol),
            text = coinItem.symbol.uppercase(),
            color = AppTheme.colors.text,
            style = AppTheme.styles.semiBold16
        )

        Text(
            modifier = Modifier
                .constrainAs(coinName) {
                    start.linkTo(coinSymbol.start)
                    top.linkTo(coinSymbol.bottom)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.preferredWrapContent
                }
                .testTag(tag = TestTagTrendingItemCoinName),
            text = coinItem.name,
            color = AppTheme.colors.coinNameText,
            style = AppTheme.styles.medium14
        )

        PriceChange(
            priceChangePercentage24hInCurrency = coinItem.priceChangePercentage24h,
            modifier = Modifier
                .constrainAs(priceChange) {
                    end.linkTo(parent.end)
                    top.linkTo(coinSymbol.top)
                    bottom.linkTo(coinName.bottom)
                    width = Dimension.preferredWrapContent
                }
                .testTag(tag = TestTagTrendingItemPriceChange)
        )
    }
}

