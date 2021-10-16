package com.example.instamemories.data.repository.album.datasourceimpl

import com.example.instamemories.data.model.album.Album
import com.example.instamemories.data.repository.album.datasource.AlbumCacheDataSource

class AlbumCacheDataSourceImpl : AlbumCacheDataSource {
    private var albumsList = ArrayList<Album>()
    override suspend fun saveAlbumsToCache(albums: List<Album>) {
        albumsList.clear()
        albumsList = ArrayList(albums)
    }

    override suspend fun getAlbumsFromCache(userId:Int): List<Album> {
       return albumsList
    }
}