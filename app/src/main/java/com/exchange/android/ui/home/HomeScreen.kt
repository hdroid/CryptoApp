package com.exchange.android.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.exchange.android.R
import com.exchange.android.extentions.boxShadow
import com.exchange.android.ui.home.components.CoinItem
import com.exchange.android.ui.home.components.PortfolioCard
import com.exchange.android.ui.theme.AppTheme


@Composable
fun HomeScreen(
    modifier: Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val coins = viewModel.getLivePrice().collectAsLazyPagingItems()

    val lazyColumnListState = rememberLazyListState()

    Surface(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
        ) {
            LazyColumn(state = lazyColumnListState) {
                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        text = stringResource(id = R.string.home_title),
                        textAlign = TextAlign.Center,
                        style = AppTheme.styles.semiBold24,
                        color = AppTheme.colors.text
                    )
                }

                item {
                    PortfolioCard(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 40.dp, end = 16.dp, bottom = 40.dp)
                            .boxShadow(
                                color = AppTheme.colors.portfolioCardShadow,
                                borderRadius = 12.dp,
                                blurRadius = 24.dp,
                                offsetY = 212.dp,
                                spread = (-6).dp
                            )
                    )
                }

                items(
                    items = coins,
                ) { coin ->
                    Box(
                        modifier = Modifier.padding(
                            start = 16.dp, end = 16.dp, bottom = 16.dp
                        )
                    ) {
                        if (coin != null) {
                            CoinItem(
                                coinItem = coin,
                                onItemClick = { }
                            )
                        }
                    }

                }

                when (val state = coins.loadState.refresh) { //FIRST LOAD
                    is LoadState.Error -> {
                        item {
                            state.error.message?.let {
                                ShowMessage(msg = it)
                            }
                        }
                    }

                    is LoadState.Loading -> { // Loading UI
                        item {
                            Progress(
                                modifier = modifier
                                    .fillMaxWidth()
                                    .height(300.dp)
                            )
                        }
                    }

                    else -> {}
                }
                when (val state = coins.loadState.append) { // Pagination
                    is LoadState.Error -> {
                        item {
                            state.error.message?.let {
                                ShowMessage(msg = it)
                            }
                        }
                    }

                    is LoadState.Loading -> { // Pagination Loading UI
                        item {
                            Progress(
                                modifier = modifier
                                    .fillMaxWidth()
                            )
                        }
                    }

                    else -> {}
                }
            }

        }
    }
}

@Composable
fun ShowMessage(msg: String) {
    Text(
        text = msg,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.Center,
        maxLines = 1,
        style = AppTheme.styles.semiBold16,
        color = AppTheme.colors.text
    )

}

@Composable
fun Progress(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(40.dp)
        )
    }

}
