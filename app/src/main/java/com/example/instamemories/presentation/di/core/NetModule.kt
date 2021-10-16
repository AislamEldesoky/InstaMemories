package com.example.instamemories.presentation.di.core

import com.example.instamemories.data.api.InstaMemoriesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule (val baseUrl : String) {
    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideInstaMemoriesService(retrofit: Retrofit) : InstaMemoriesService{
        return retrofit.create(InstaMemoriesService::class.java)
    }
}