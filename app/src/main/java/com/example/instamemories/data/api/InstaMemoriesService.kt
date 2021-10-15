package com.example.instamemories.data.api

import com.example.instamemories.data.model.album.AlbumsList
import com.example.instamemories.data.model.photo.PhotosList
import com.example.instamemories.data.model.user.UsersList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface InstaMemoriesService {

    @GET("users")
    suspend fun getUsers() :Response<UsersList>

    @GET("albums")
    suspend fun getUserAlbums(@Query("userId")userId:Int) :Response<AlbumsList>

    @GET("photos")
    suspend fun getAlbumPhoto(@Query("albumId")albumId:Int) :Response<PhotosList>
}