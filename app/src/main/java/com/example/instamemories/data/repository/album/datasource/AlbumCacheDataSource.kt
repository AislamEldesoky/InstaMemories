package com.example.instamemories.data.repository.album.datasource

import com.example.instamemories.data.model.album.Album
import com.example.instamemories.data.model.photo.Photo

interface AlbumCacheDataSource {
    suspend fun saveAlbumsToCache(albums: List<Album>)
    suspend fun getAlbumsFromCache() : List<Album>
}