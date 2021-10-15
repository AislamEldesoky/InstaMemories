package com.example.instamemories.data.repository.photo

import com.example.instamemories.data.api.InstaMemoriesService
import com.example.instamemories.data.model.photo.PhotosList
import retrofit2.Response

class PhotoRemoteDataSourceImpl(
    private val instaMemoriesService: InstaMemoriesService,
    private val albumId: Int
) : PhotoRemoteDataSource {
    override suspend fun getPhotos(): Response<PhotosList> =
        instaMemoriesService.getAlbumPhoto(albumId)
}