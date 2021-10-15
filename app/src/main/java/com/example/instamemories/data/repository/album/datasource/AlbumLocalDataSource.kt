package com.example.instamemories.data.repository.album.datasource

import com.example.instamemories.data.model.album.Album

interface AlbumLocalDataSource {
    suspend fun getAlbumsFromDB(): List<Album>
    suspend fun saveAlbumsToDB(albums : List<Album>)
    suspend fun clearAlbumsFromDB()
}