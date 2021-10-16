package com.example.instamemories.presentation

import android.app.Application
import android.content.Context
import com.example.instamemories.BuildConfig
import com.example.instamemories.presentation.di.Injector
import com.example.instamemories.presentation.di.core.*
import com.example.instamemories.presentation.di.photo.PhotoSubComponent
import com.example.instamemories.presentation.di.user.UserSubComponent
import dagger.Component
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerApplication
import dagger.internal.DaggerCollections

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent
    private  val userId : Int = 0
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(4))
            .build()
    }

    override fun createUserSubComponent(): UserSubComponent {
        return appComponent.userSubComponent().create()
    }

    override fun createPhotoSubComponent(): PhotoSubComponent {
        return appComponent.photoSubComponent().create()
    }
}