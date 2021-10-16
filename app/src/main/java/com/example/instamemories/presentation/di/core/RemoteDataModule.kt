package com.example.instamemories.presentation.di.core

import com.example.instamemories.data.api.InstaMemoriesService
import com.example.instamemories.data.repository.album.datasource.AlbumRemoteDataSource
import com.example.instamemories.data.repository.album.datasourceimpl.AlbumRemoteDataSourceImpl
import com.example.instamemories.data.repository.photo.datasource.PhotoRemoteDataSource
import com.example.instamemories.data.repository.photo.datasourceimpl.PhotoRemoteDataSourceImpl
import com.example.instamemories.data.repository.user.UserRemoteDataSource
import com.example.instamemories.data.repository.user.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule() {

    @Singleton
    @Provides
    fun provideUserRemoteDataSource(instaMemoriesService: InstaMemoriesService):UserRemoteDataSource{
        return UserRemoteDataSourceImpl(instaMemoriesService)
    }

    @Singleton
    @Provides
    fun provideAlbumRemoteDataSource(instaMemoriesService: InstaMemoriesService):AlbumRemoteDataSource{
        return AlbumRemoteDataSourceImpl(instaMemoriesService)
    }
    @Singleton
    @Provides
    fun providePhotoRemoteDataSource(instaMemoriesService: InstaMemoriesService):PhotoRemoteDataSource{
        return PhotoRemoteDataSourceImpl(instaMemoriesService)
    }
}