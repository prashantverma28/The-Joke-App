package com.unlimint.thejokeapp.di

import com.google.gson.GsonBuilder
import com.unlimint.thejokeapp.api.RemoteDataSource
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val remoteModule = module {
    single<Retrofit> {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        Retrofit.Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    single<RemoteDataSource> { get<Retrofit>().create(RemoteDataSource::class.java) }

}
