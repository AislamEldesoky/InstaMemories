package com.example.instamemories.presentation.di.core

import com.example.instamemories.data.db.AlbumDao
import com.example.instamemories.data.db.PhotoDao
import com.example.instamemories.data.repository.album.datasource.AlbumLocalDataSource
import com.example.instamemories.data.repository.album.datasourceimpl.AlbumLocalDataSourceImpl
import com.example.instamemories.data.repository.photo.datasource.PhotoLocalDataSource
import com.example.instamemories.data.repository.photo.datasourceimpl.PhotoLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providePhotoLocalDataSource(photoDao: PhotoDao) : PhotoLocalDataSource{
        return PhotoLocalDataSourceImpl(photoDao)
    }
    @Singleton
    @Provides
    fun provideAlbumLocalDataSource(albumDao: AlbumDao) : AlbumLocalDataSource{
        return AlbumLocalDataSourceImpl(albumDao)
    }
}