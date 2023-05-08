package com.unlimint.thejokeapp.repository

import com.unlimint.thejokeapp.database.JokeDao
import com.unlimint.thejokeapp.database.Joke

interface JokeRepository {

    suspend fun getRemoteJokeList(): ArrayList<Joke>?
    suspend fun getLocalJokeList(): ArrayList<Joke>?

}