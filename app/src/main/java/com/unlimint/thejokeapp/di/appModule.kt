package com.unlimint.thejokeapp.di

import com.unlimint.thejokeapp.repository.JokeRepository
import com.unlimint.thejokeapp.repository.JokeRepositoryImpl
import com.unlimint.thejokeapp.viewmodel.JokeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<JokeRepository> {
        JokeRepositoryImpl(get(), get())
    }

    viewModel { JokeViewModel(get()) }

}