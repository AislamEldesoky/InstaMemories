package com.example.instamemories.data.repository.photo.datasource

import com.example.instamemories.data.model.photo.Photo

interface PhotoLocalDataSource {

    suspend fun getPhotosFromDB(): List<Photo>
    suspend fun savePhotosToDB(photos : List<Photo>)
    suspend fun clearPhotosFromDB()
}