package com.exchange.android.data.remote.dto

import com.squareup.moshi.Json

data class LivePriceResponse(
    @field:Json(name = "msg")
    val msg: String,
    @field:Json(name = "result")
    val result: List<CoinResponse>,
    @field:Json(name = "status")
    val status: Boolean,
    @field:Json(name = "total")
    val total: Int
)
