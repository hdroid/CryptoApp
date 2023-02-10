package com.exchange.android.domain.repository

import androidx.paging.PagingData
import com.exchange.android.domain.model.Coin
import kotlinx.coroutines.flow.Flow

interface LivePriceRepository {

    fun getLivePrice(): Flow<PagingData<Coin>>
}