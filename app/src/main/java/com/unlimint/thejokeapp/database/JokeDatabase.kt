package com.unlimint.thejokeapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Joke::class], version = 1, exportSchema = false)
abstract class JokeDatabase : RoomDatabase() {

    abstract fun getJokeDao(): JokeDao
}