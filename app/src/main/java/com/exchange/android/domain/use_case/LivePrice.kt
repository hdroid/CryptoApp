package com.exchange.android.domain.use_case

import androidx.paging.PagingData
import com.exchange.android.domain.model.Coin
import com.exchange.android.domain.repository.LivePriceRepository
import kotlinx.coroutines.flow.Flow

class LivePrice(
    private val repository: LivePriceRepository
) {

    fun getLivePrice(): Flow<PagingData<Coin>> {
        return repository.getLivePrice()
    }

}