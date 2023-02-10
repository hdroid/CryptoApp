package com.exchange.android.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.exchange.android.data.local.entity.CoinEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LivePriceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoins(coins: List<CoinEntity>)

    @Query("SELECT * FROM CoinEntity")
    suspend fun getCoins(): List<CoinEntity>

}