package com.example.instamemories.data.repository.album

import android.util.Log
import com.example.instamemories.data.model.album.Album
import com.example.instamemories.data.model.album.AlbumsList
import com.example.instamemories.data.model.user.User
import com.example.instamemories.data.model.user.UsersList
import com.example.instamemories.domain.repository.AlbumRepository
import retrofit2.Response
import java.lang.Exception

class AlbumRepositoryImpl (private val albumRemoteDataSource: AlbumRemoteDataSource): AlbumRepository {
    override suspend fun getAlbums(): List<Album> {
        return getAlbumsFromAPI()
    }

    suspend fun getAlbumsFromAPI() : List<Album>{
        lateinit var albumsList : List<Album>
        try {
            val response : Response<AlbumsList> = albumRemoteDataSource.getAlbums()
            val body = response.body()
            if(body!=null){
                albumsList =body
            }
        }catch (exception : Exception){
            Log.i("Err",exception.message.toString())
        }
        return albumsList
    }
}