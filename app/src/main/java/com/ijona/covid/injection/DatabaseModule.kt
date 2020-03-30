package com.ijona.covid.injection


import android.content.Context
import androidx.room.Room
import com.ijona.covid.data.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { provideAppDatabase(get()) }
    single { provideCoronaDao(get()) }
}

const val DATABASE_NAME = "corona_db"

private fun provideAppDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()
}


private fun provideCoronaDao(database: AppDatabase) = database.coronaDao()
