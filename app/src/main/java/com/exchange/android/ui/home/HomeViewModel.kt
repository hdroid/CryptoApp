package com.exchange.android.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.exchange.android.domain.model.Coin
import com.exchange.android.domain.use_case.LivePrice
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val livePrice: LivePrice,
) : ViewModel() {

    fun getLivePrice() : Flow<PagingData<Coin>> =
        livePrice.getLivePrice().cachedIn(viewModelScope)
}