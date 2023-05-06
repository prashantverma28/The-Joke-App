package com.unlimint.thejokeapp.api

import com.unlimint.thejokeapp.database.Joke
import retrofit2.http.GET

interface RemoteDataSource {
    @GET("api?format=json")
    suspend fun getData(): Joke
}