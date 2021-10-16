package com.example.instamemories.presentation.di.core

import android.content.Context
import com.example.instamemories.presentation.di.photo.PhotoSubComponent
import com.example.instamemories.presentation.di.user.UserSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [UserSubComponent::class,PhotoSubComponent::class])
class AppModule (private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}