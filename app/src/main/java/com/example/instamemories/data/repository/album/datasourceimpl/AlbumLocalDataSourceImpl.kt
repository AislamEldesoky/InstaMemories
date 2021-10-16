package com.example.instamemories.data.repository.album.datasourceimpl

import com.example.instamemories.data.db.AlbumDao
import com.example.instamemories.data.model.album.Album
import com.example.instamemories.data.repository.album.datasource.AlbumLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumLocalDataSourceImpl (private val albumDao: AlbumDao) : AlbumLocalDataSource {
    override fun getAlbumsFromDB(userId:Int): List<Album> {
        return albumDao.getAlbums()
    }

    override fun saveAlbumsToDB(albums: List<Album>) {
        CoroutineScope(Dispatchers.IO).launch {
            albumDao.saveAlbums(albums)
        }
    }

    override fun clearAlbumsFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            albumDao.deleteAlbums()
        }
    }
}