package com.exchange.android.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.exchange.android.data.local.LivePriceDao
import com.exchange.android.data.mapper.toCoin
import com.exchange.android.data.mapper.toCoinEntity
import com.exchange.android.data.remote.OkApi
import com.exchange.android.domain.common.defaultSize
import com.exchange.android.domain.model.Coin

class LivePricePagingSource(
    private val dao: LivePriceDao,
    private val api: OkApi
) : PagingSource<Int, Coin>() {

    override fun getRefreshKey(state: PagingState<Int, Coin>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Coin> {
        val page = params.key ?: 1
        val size = defaultSize
        return try {

            val coinsDto = api.getLivePrice(
                page = page,
                pageSize = size
            )
            if (coinsDto.status) {
                dao.insertCoins(
                    coinsDto.result.map {
                        it.toCoinEntity()
                    }
                )
                LoadResult.Page(
                    data = coinsDto.result
                        .map { it.toCoin() },
                    prevKey = if (page == 1) null else page.minus(1),
                    nextKey = if (coinsDto.result.isEmpty()) null else page.plus(1),
                )
            } else {
                LoadResult.Error(Throwable(coinsDto.msg))
            }
        } catch (e: Exception) {
            if (page == 1) {
                val localCoins = dao.getCoins()
                if (localCoins.isNotEmpty()) {
                    LoadResult.Page(
                        data = localCoins
                            .map { it.toCoin() },
                        prevKey = null,
                        nextKey = page.plus(1),
                    )
                } else
                    LoadResult.Error(e)
            } else LoadResult.Error(e)
        }
    }
}