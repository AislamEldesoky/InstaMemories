package com.example.instamemories.data.repository.photo.datasourceimpl

import com.example.instamemories.data.model.photo.Photo
import com.example.instamemories.data.repository.photo.datasource.PhotoCacheDataSource

class PhotoCacheDataSourceImpl : PhotoCacheDataSource {
    private var photosList = ArrayList<Photo>()
    override suspend fun savePhotosToCache(photos: List<Photo>) {
        photosList.clear()
        photosList = ArrayList(photos)
    }

    override suspend fun getPhotosFromCache(): List<Photo> {
        return photosList
    }
}