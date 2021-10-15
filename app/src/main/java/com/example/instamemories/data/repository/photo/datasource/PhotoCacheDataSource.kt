package com.example.instamemories.data.repository.photo.datasource

import com.example.instamemories.data.model.photo.Photo

interface PhotoCacheDataSource {
    suspend fun savePhotosToCache(photos: List<Photo>)
    suspend fun getPhotosFromCache() : List<Photo>
}