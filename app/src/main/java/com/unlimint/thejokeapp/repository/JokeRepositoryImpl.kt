package com.unlimint.thejokeapp.repository

import android.widget.Toast
import com.unlimint.thejokeapp.database.Joke
import com.unlimint.thejokeapp.api.RemoteDataSource
import com.unlimint.thejokeapp.database.LocalDataSource

class JokeRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : JokeRepository {

    override suspend fun getJokeList(): ArrayList<Joke>? {
        val jokeDao = localDataSource.getJokeDao()
        try {
            val joke = remoteDataSource.getData()
            jokeDao.insert(joke)
        }catch (_: Exception){

        }
        return jokeDao.getAllJokes()?.let {
            it as ArrayList<Joke>
            it.reverse()
            it
        } ?: kotlin.run {
            null
        }
    }

}