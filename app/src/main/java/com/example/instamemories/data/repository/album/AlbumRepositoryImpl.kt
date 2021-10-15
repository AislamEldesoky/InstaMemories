package com.example.instamemories.data.repository.album

import android.util.Log
import com.example.instamemories.data.model.album.Album
import com.example.instamemories.data.model.album.AlbumsList
import com.example.instamemories.data.repository.album.datasource.AlbumCacheDataSource
import com.example.instamemories.data.repository.album.datasource.AlbumLocalDataSource
import com.example.instamemories.data.repository.album.datasource.AlbumRemoteDataSource
import com.example.instamemories.domain.repository.AlbumRepository
import retrofit2.Response
import java.lang.Exception

class AlbumRepositoryImpl(
    private val albumRemoteDataSource: AlbumRemoteDataSource,
    private val albumLocalDataSource: AlbumLocalDataSource,
    private val albumCacheDataSource: AlbumCacheDataSource
) : AlbumRepository {
    override suspend fun getAlbums(): List<Album> {
        return getAlbumsFromAPI()
    }

    suspend fun getAlbumsFromAPI(): List<Album> {
        lateinit var albumsList: List<Album>
        try {
            val response: Response<AlbumsList> = albumRemoteDataSource.getAlbums()
            val body = response.body()
            if (body != null) {
                albumsList = body
            }
        } catch (exception: Exception) {
            Log.i("Err", exception.message.toString())
        }
        return albumsList
    }

    suspend fun getAlbumsFromDB(): List<Album> {
        lateinit var albumsList: List<Album>
        try {
            albumsList = albumLocalDataSource.getAlbumsFromDB()
        } catch (exception: Exception) {
            Log.i("Err", exception.message.toString())
        }
        if (albumsList.size > 0) {
            return albumsList
        } else {
            albumsList = getAlbumsFromAPI()
            albumLocalDataSource.saveAlbumsToDB(albumsList)
        }
        return albumsList
    }

    suspend fun getAlbumsFromCache() : List<Album>{

        lateinit var albumsList: List<Album>
        try {
            albumsList = albumCacheDataSource.getAlbumsFromCache()
        } catch (exception: Exception) {
            Log.i("Err", exception.message.toString())
        }
        if (albumsList.size > 0) {
            return albumsList
        } else {
            albumsList = getAlbumsFromDB()
            albumCacheDataSource.saveAlbumsToCache(albumsList)
        }
        return albumsList
    }
}