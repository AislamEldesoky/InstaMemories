package com.example.instamemories.data.api

import com.example.instamemories.data.model.album.AlbumsList
import com.example.instamemories.data.model.photo.PhotosList
import com.example.instamemories.data.model.user.User
import com.example.instamemories.data.model.user.UsersList
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface InstaMemoriesService {

    @GET("users")
     fun getUsers() : Single<List<User>>

    @GET("albums")
    fun getUserAlbums(@Query("userId")userId:Int) :Single<AlbumsList>

    @GET("photos")
    suspend fun getAlbumPhotos(@Query("albumId")albumId:Int) :Response<PhotosList>
}