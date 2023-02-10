package com.exchange.android.di

import android.app.Application
import androidx.room.Room
import com.exchange.android.data.local.OkDatabase
import com.exchange.android.data.remote.OkApi
import com.exchange.android.data.repository.LivePricePagingSource
import com.exchange.android.data.repository.LivePriceRepositoryImp
import com.exchange.android.domain.repository.LivePriceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideOkApi(client: OkHttpClient): OkApi {
        return Retrofit.Builder()
            .baseUrl(OkApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideOkDatabase(app: Application): OkDatabase {
        return Room.databaseBuilder(
            app,
            OkDatabase::class.java,
            "ok_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideLivePriceRepository(
        pageSource: LivePricePagingSource,
    ): LivePriceRepository {
        return LivePriceRepositoryImp(
            pageSource
        )
    }

    @Provides
    @Singleton
    fun provideLivePricePagingSource(
        api: OkApi,
        db: OkDatabase
    ): LivePricePagingSource {
        return LivePricePagingSource(
            dao = db.dao,
            api = api
        )
    }
}