package com.example.instamemories.data.repository.photo.datasourceimpl

import com.example.instamemories.data.api.InstaMemoriesService
import com.example.instamemories.data.model.photo.PhotosList
import com.example.instamemories.data.repository.photo.datasource.PhotoRemoteDataSource
import retrofit2.Response

class PhotoRemoteDataSourceImpl(
    private val instaMemoriesService: InstaMemoriesService,
    private val albumId: Int
) : PhotoRemoteDataSource {
    override suspend fun getPhotos(): Response<PhotosList> =
        instaMemoriesService.getAlbumPhotos(albumId)
}