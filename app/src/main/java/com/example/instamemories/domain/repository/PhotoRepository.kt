package com.example.instamemories.domain.repository

import com.example.instamemories.data.model.photo.Photo

interface PhotoRepository {
    suspend fun getPhotos():List<Photo>
}