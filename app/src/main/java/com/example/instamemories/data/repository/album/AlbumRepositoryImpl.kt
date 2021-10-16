package com.example.instamemories.data.repository.album

import android.util.Log
import com.example.instamemories.data.model.album.Album
import com.example.instamemories.data.model.album.AlbumsList
import com.example.instamemories.data.repository.album.datasource.AlbumCacheDataSource
import com.example.instamemories.data.repository.album.datasource.AlbumLocalDataSource
import com.example.instamemories.data.repository.album.datasource.AlbumRemoteDataSource
import com.example.instamemories.domain.repository.AlbumRepository
import io.reactivex.Single
import retrofit2.Response
import java.lang.Exception

class AlbumRepositoryImpl(
    private val albumRemoteDataSource: AlbumRemoteDataSource,
    private val albumLocalDataSource: AlbumLocalDataSource,
    private val albumCacheDataSource: AlbumCacheDataSource
) : AlbumRepository {
    override fun getAlbums(userId: Int): Single<AlbumsList> {
        return getAlbumsFromAPI(userId)
    }

    fun getAlbumsFromAPI(userId: Int): Single<AlbumsList> {
        lateinit var albumsList: Single<AlbumsList>
        try {
            val response: Single<AlbumsList> = albumRemoteDataSource.getAlbums(userId)
            val body = response
            if (body != null) {
                albumsList = body
            }
        } catch (exception: Exception) {
            Log.i("Err", exception.message.toString())
        }
        return albumsList
    }

    fun getAlbumsFromDB(userId: Int): List<Album> {
        lateinit var albumsList: List<Album>
        try {
            albumsList = albumLocalDataSource.getAlbumsFromDB(userId)
        } catch (exception: Exception) {
            Log.i("Err", exception.message.toString())
        }
        if (albumsList.size > 0) {
            return albumsList
        } else {
            albumsList = getAlbumsFromAPI(userId) as List<Album>
            albumLocalDataSource.saveAlbumsToDB(albumsList)
        }
        return albumsList
    }

    suspend fun getAlbumsFromCache(userId: Int): List<Album> {

        lateinit var albumsList: List<Album>
        try {
            albumsList = albumCacheDataSource.getAlbumsFromCache(userId)
        } catch (exception: Exception) {
            Log.i("Err", exception.message.toString())
        }
        if (albumsList.size > 0) {
            return albumsList
        } else {
            albumsList = getAlbumsFromDB(userId)
            albumCacheDataSource.saveAlbumsToCache(albumsList)
        }
        return albumsList
    }
}