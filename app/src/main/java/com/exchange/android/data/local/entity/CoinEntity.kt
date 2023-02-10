package com.exchange.android.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CoinEntity(
    @PrimaryKey
    val id: String,
    val marketCapRank: Int,
    val image: String,
    val currentPrice: Double,
    val name: String,
    val symbol: String,
    val priceChangePercentage24h: Double,
)
