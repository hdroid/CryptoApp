package com.exchange.android.data.remote

import com.exchange.android.data.remote.dto.LivePriceResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OkApi {
    @GET("live-price")
    suspend fun getLivePrice(
        @Query("page") page: Int,
        @Query("size") pageSize: Int
    ): LivePriceResponse

    companion object {
        const val BASE_URL = "https://ok-ex.io/api/v1/"
    }
}