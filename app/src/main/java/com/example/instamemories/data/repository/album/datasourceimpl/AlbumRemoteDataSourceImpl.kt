package com.example.instamemories.data.repository.album.datasourceimpl

import com.example.instamemories.data.api.InstaMemoriesService
import com.example.instamemories.data.model.album.AlbumsList
import com.example.instamemories.data.repository.album.datasource.AlbumRemoteDataSource
import retrofit2.Response

class AlbumRemoteDataSourceImpl(
    private val instaMemoriesService: InstaMemoriesService,
    private val userId: Int
) : AlbumRemoteDataSource {
    override suspend fun getAlbums(): Response<AlbumsList> =
        instaMemoriesService.getUserAlbums(userId)

}