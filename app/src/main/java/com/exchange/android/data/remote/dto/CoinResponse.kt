package com.exchange.android.data.remote.dto


import com.squareup.moshi.Json


data class CoinResponse(
    @field:Json(name = "circulating_supply")
    val circulatingSupply: String,
    @field:Json(name = "current_price")
    val currentPrice: Double,
    @field:Json(name = "has_price")
    val hasPrice: Boolean,
    @field:Json(name = "has_rank")
    val hasRank: Boolean,
    @field:Json(name = "high_24h")
    val high24h: String,
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "image")
    val image: String,
    @field:Json(name = "low_24h")
    val low24h: String,
    @field:Json(name = "market_cap")
    val marketCap: String,
    @field:Json(name = "market_cap_rank")
    val marketCapRank: Int,
    @field:Json(name = "max_supply")
    val maxSupply: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "price_change_percentage_1h_in_currency")
    val priceChangePercentage1hInCurrency: Double,
    @field:Json(name = "price_change_percentage_24h")
    val priceChangePercentage24h: Double,
    @field:Json(name = "price_change_percentage_7d_in_currency")
    val priceChangePercentage7dInCurrency: Double,
    @field:Json(name = "pt")
    val pt: Double,
    @field:Json(name = "symbol")
    val symbol: String,
    @field:Json(name = "total_supply")
    val totalSupply: String,
    @field:Json(name = "total_volume")
    val totalVolume: String,
)

