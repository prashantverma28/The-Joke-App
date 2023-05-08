package com.unlimint.thejokeapp.repository

import android.widget.Toast
import com.unlimint.thejokeapp.database.Joke
import com.unlimint.thejokeapp.api.RemoteDataSource
import com.unlimint.thejokeapp.database.JokeDao
import com.unlimint.thejokeapp.database.LocalDataSource

class JokeRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : JokeRepository {

    override suspend fun getRemoteJokeList(): ArrayList<Joke>? {
        try {
            val joke = remoteDataSource.getData()
            localDataSource.getJokeDao().insert(joke)
        }catch (_: Exception){

        }
        return getLocalJokes()
    }

    override suspend fun getLocalJokeList(): ArrayList<Joke>? {
        return getLocalJokes()
    }

    private suspend fun getLocalJokes() : ArrayList<Joke>?{
        return localDataSource.getJokeDao().getAllJokes()?.let {
            it as ArrayList<Joke>
            it.reverse()
            it
        } ?: kotlin.run {
            null
        }
    }

}