package com.unlimint.thejokeapp.database

interface LocalDataSource {
    suspend fun getJokeDao(): JokeDao
}