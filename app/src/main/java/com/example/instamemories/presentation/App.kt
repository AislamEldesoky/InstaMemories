package com.example.instamemories.presentation

import android.app.Application
import com.example.instamemories.presentation.di.Injector
import com.example.instamemories.presentation.di.core.AppComponent
import com.example.instamemories.presentation.di.photo.PhotoSubComponent
import com.example.instamemories.presentation.di.user.UserSubComponent
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerApplication
import dagger.internal.DaggerCollections

class App : Application(), Injector {
    private lateinit var appComponent : AppComponent
    override fun onCreate() {
        super.onCreate()
       // appComponent = DaggerApp
    }

    override fun createUserSubComponent(): UserSubComponent {
        TODO("Not yet implemented")
    }

    override fun createPhotoSubComponent(): PhotoSubComponent {
        TODO("Not yet implemented")
    }
}