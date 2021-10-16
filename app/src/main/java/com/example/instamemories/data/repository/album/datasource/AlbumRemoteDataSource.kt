package com.example.instamemories.data.repository.album.datasource

import com.example.instamemories.data.model.album.AlbumsList
import com.example.instamemories.data.model.user.UsersList
import io.reactivex.Single
import retrofit2.Response

interface AlbumRemoteDataSource {
     fun getAlbums(userId:Int) : Single<AlbumsList>
}