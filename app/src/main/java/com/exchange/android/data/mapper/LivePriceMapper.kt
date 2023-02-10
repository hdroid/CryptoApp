package com.exchange.android.data.mapper

import com.exchange.android.data.local.entity.CoinEntity
import com.exchange.android.data.remote.dto.CoinResponse
import com.exchange.android.domain.model.Coin

fun CoinResponse.toCoin(): Coin {
    return Coin(
        id = id,
        marketCapRank = marketCapRank,
        image = image,
        name = name,
        symbol = symbol,
        priceChangePercentage24h = priceChangePercentage24h,
        currentPrice = currentPrice,
    )
}

fun CoinEntity.toCoin(): Coin {
    return Coin(
        id = id,
        marketCapRank = marketCapRank,
        image = image,
        name = name,
        symbol = symbol,
        priceChangePercentage24h = priceChangePercentage24h,
        currentPrice = currentPrice,
    )
}

fun CoinResponse.toCoinEntity(): CoinEntity {
    return CoinEntity(
        id = id,
        marketCapRank = marketCapRank,
        image = image,
        name = name,
        symbol = symbol,
        priceChangePercentage24h = priceChangePercentage24h,
        currentPrice = currentPrice,
    )
}


