package com.example.instamemories.presentation.di.core

import com.example.instamemories.presentation.di.photo.PhotoSubComponent
import com.example.instamemories.presentation.di.user.UserSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        DatabaseModule::class,
        LocalDataModule::class,
        CacheDataModule::class,
        RemoteDataModule::class
    ]
)
interface AppComponent {
    fun userSubComponent(): UserSubComponent.factory
    fun photoSubComponent(): PhotoSubComponent.factory
}