package com.exchange.android.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.exchange.android.R
import com.exchange.android.ui.theme.AppTheme


const val TestTagTotalCoinsLabel = "CardTotalCoinsLabel"
const val TestTagTodayCoinProfitLabel = "todayProfitLabel"
const val TestTagCardTotalCoins = "CardTotalCoins"
const val TestTagCardTodayProfit = "CardTodayProfit"

@Composable
fun PortfolioCard(
    modifier: Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = AppTheme.colors.portfolioCardBackgroundGradient,
                )
            )
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        val (
            totalCoinsLabel,
            totalCoins,
            todayProfitLabel,
            todayProfit,
            profitPercent
        ) = createRefs()

        Text(
            modifier = Modifier
                .constrainAs(totalCoinsLabel) {
                    start.linkTo(parent.start)
                }
                .testTag(TestTagTotalCoinsLabel),
            text = stringResource(R.string.portfolio_card_total_coin_label),
            style = AppTheme.styles.lightSilverMedium16
        )

        Text(
            modifier = Modifier
                .constrainAs(totalCoins) {
                    top.linkTo(totalCoinsLabel.bottom, margin = 8.dp)
                }
                .testTag(tag = TestTagCardTotalCoins),
            text = stringResource(R.string.coin_currency, "7,273,291"),
            style = AppTheme.styles.whiteSemiBold24
        )
        Text(
            modifier = Modifier
                .constrainAs(todayProfitLabel) {
                    top.linkTo(totalCoins.bottom, margin = 40.dp)
                }
                .testTag(tag = TestTagTodayCoinProfitLabel),
            text = stringResource(R.string.portfolio_card_today_profit_label),
            style = AppTheme.styles.lightSilverMedium16
        )

        Text(
            modifier = Modifier
                .constrainAs(todayProfit) {
                    top.linkTo(todayProfitLabel.bottom, margin = 8.dp)
                }
                .testTag(tag = TestTagCardTodayProfit),
            text = stringResource(R.string.coin_currency, "193,280"),
            style = AppTheme.styles.whiteSemiBold24
        )

        PriceChangeButton(
            modifier = Modifier
                .constrainAs(profitPercent) {
                    linkTo(top = todayProfitLabel.top, bottom = todayProfit.bottom)
                    end.linkTo(parent.end)
                },
            priceChangePercent = 6.21,
        )
    }
}
