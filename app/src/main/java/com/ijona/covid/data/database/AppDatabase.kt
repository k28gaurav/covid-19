package com.ijona.covid.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ijona.covid.data.database.dao.CoronaEntityDao
import com.ijona.covid.data.database.model.Area
import com.ijona.covid.data.database.model.CoronaEntity

@Database(entities =[CoronaEntity::class, Area::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coronaDao(): CoronaEntityDao
}