package com.example.instamemories.presentation.di.core

import com.example.instamemories.data.repository.album.datasource.AlbumCacheDataSource
import com.example.instamemories.data.repository.album.datasourceimpl.AlbumCacheDataSourceImpl
import com.example.instamemories.data.repository.album.datasourceimpl.AlbumLocalDataSourceImpl
import com.example.instamemories.data.repository.photo.datasource.PhotoCacheDataSource
import com.example.instamemories.data.repository.photo.datasourceimpl.PhotoCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providesPhotoCacheDataSource():PhotoCacheDataSource{
        return PhotoCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun providesAlbumCacheDataSource():AlbumCacheDataSource{
        return AlbumCacheDataSourceImpl()
    }
}