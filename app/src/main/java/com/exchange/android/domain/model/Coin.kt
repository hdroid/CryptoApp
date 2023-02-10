package com.exchange.android.domain.model


data class Coin(
    val id: String,
    val marketCapRank: Int,
    val image: String,
    val currentPrice: Double,
    val name: String,
    val symbol: String,
    val priceChangePercentage24h: Double,
)
