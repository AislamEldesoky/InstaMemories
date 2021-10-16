package com.example.instamemories.data.repository.album.datasource

import com.example.instamemories.data.model.album.Album
import io.reactivex.Single

interface AlbumLocalDataSource {
    fun getAlbumsFromDB(userId:Int): List<Album>
    fun saveAlbumsToDB(albums : List<Album>)
    fun clearAlbumsFromDB()
}