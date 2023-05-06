package com.unlimint.thejokeapp.database

class LocalDataSourceImpl(private val jokeDatabase: JokeDatabase) : LocalDataSource {

    override suspend fun getJokeDao(): JokeDao {
        return jokeDatabase.getJokeDao()
    }

}