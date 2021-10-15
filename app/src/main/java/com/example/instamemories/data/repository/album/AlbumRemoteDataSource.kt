package com.example.instamemories.data.repository.album

import com.example.instamemories.data.model.album.AlbumsList
import com.example.instamemories.data.model.user.UsersList
import retrofit2.Response

interface AlbumRemoteDataSource {
    suspend fun getAlbums() : Response<AlbumsList>
}