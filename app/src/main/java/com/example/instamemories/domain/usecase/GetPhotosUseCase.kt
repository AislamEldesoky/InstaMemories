package com.example.instamemories.domain.usecase

import com.example.instamemories.data.model.photo.Photo
import com.example.instamemories.domain.repository.PhotoRepository

class GetPhotosUseCase(private val photoRepository: PhotoRepository) {
    suspend fun execute():List<Photo>? = photoRepository.getPhotos()
}