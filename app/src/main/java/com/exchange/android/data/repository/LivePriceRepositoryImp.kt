package com.exchange.android.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.exchange.android.domain.common.defaultSize
import com.exchange.android.domain.model.Coin
import com.exchange.android.domain.repository.LivePriceRepository
import kotlinx.coroutines.flow.Flow

class LivePriceRepositoryImp(
    private val pageSource: LivePricePagingSource
) : LivePriceRepository {

    override fun getLivePrice(): Flow<PagingData<Coin>> {
        return Pager(
            config = PagingConfig(
                pageSize = defaultSize,
            ),
            pagingSourceFactory = {
                pageSource
            }
        ).flow
    }
}