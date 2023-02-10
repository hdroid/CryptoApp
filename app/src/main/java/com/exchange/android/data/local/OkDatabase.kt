package com.exchange.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.exchange.android.data.local.entity.CoinEntity

@Database(
    entities = [CoinEntity::class],
    version = 1
)
abstract class OkDatabase : RoomDatabase() {
    abstract val dao: LivePriceDao

}