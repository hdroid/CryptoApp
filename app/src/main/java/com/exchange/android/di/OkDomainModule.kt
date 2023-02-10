package com.exchange.android.di

import com.exchange.android.domain.repository.LivePriceRepository
import com.exchange.android.domain.use_case.LivePrice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object OkDomainModule {

    @ViewModelScoped
    @Provides
    fun provideLivePrice(
        repository: LivePriceRepository
    ): LivePrice {
        return LivePrice(
            repository = repository
        )
    }
}