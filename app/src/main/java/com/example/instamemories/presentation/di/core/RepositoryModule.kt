package com.example.instamemories.presentation.di.core

import com.example.instamemories.data.repository.album.AlbumRepositoryImpl
import com.example.instamemories.data.repository.album.datasource.AlbumCacheDataSource
import com.example.instamemories.data.repository.album.datasource.AlbumLocalDataSource
import com.example.instamemories.data.repository.album.datasource.AlbumRemoteDataSource
import com.example.instamemories.data.repository.album.datasourceimpl.AlbumRemoteDataSourceImpl
import com.example.instamemories.data.repository.photo.PhotoRepositoryImpl
import com.example.instamemories.data.repository.photo.datasource.PhotoCacheDataSource
import com.example.instamemories.data.repository.photo.datasource.PhotoLocalDataSource
import com.example.instamemories.data.repository.photo.datasource.PhotoRemoteDataSource
import com.example.instamemories.data.repository.user.UserRemoteDataSource
import com.example.instamemories.data.repository.user.UserRepositoryImpl
import com.example.instamemories.domain.repository.AlbumRepository
import com.example.instamemories.domain.repository.PhotoRepository
import com.example.instamemories.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource): UserRepository{
        return UserRepositoryImpl(userRemoteDataSource)
    }
    @Singleton
    @Provides
    fun providePhotoRepository(photoRemoteDataSource: PhotoRemoteDataSource,photoLocalDataSource: PhotoLocalDataSource,photoCacheDataSource: PhotoCacheDataSource): PhotoRepository{
        return PhotoRepositoryImpl(photoRemoteDataSource,photoLocalDataSource,photoCacheDataSource)
    }
    @Singleton
    @Provides
    fun provideAlbumRepository(albumRemoteDataSource: AlbumRemoteDataSource,albumLocalDataSource: AlbumLocalDataSource,albumCacheDataSource: AlbumCacheDataSource): AlbumRepository{
        return AlbumRepositoryImpl(albumRemoteDataSource,albumLocalDataSource,albumCacheDataSource)
    }
}