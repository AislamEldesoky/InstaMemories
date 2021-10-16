package com.example.instamemories.data.repository.album.datasourceimpl

import com.example.instamemories.data.api.InstaMemoriesService
import com.example.instamemories.data.model.album.AlbumsList
import com.example.instamemories.data.repository.album.datasource.AlbumRemoteDataSource
import io.reactivex.Single
import retrofit2.Response

class AlbumRemoteDataSourceImpl(
    private val instaMemoriesService: InstaMemoriesService,

) : AlbumRemoteDataSource {
    override  fun getAlbums(userId:Int): Single<AlbumsList> =
        instaMemoriesService.getUserAlbums(userId)
}