package com.unlimint.thejokeapp.di

import androidx.room.Room
import com.unlimint.thejokeapp.database.LocalDataSource
import com.unlimint.thejokeapp.database.LocalDataSourceImpl
import com.unlimint.thejokeapp.database.JokeDatabase
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            get(),
            JokeDatabase::class.java,
            "Jokes-db"
        ).allowMainThreadQueries()
            .build()
    }

    single<LocalDataSource> { LocalDataSourceImpl(get()) }
}