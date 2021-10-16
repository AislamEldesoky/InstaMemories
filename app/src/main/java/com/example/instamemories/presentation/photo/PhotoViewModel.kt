package com.example.instamemories.presentation.photo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.instamemories.data.model.photo.Photo
import com.example.instamemories.domain.usecase.GetPhotosUseCase

class PhotoViewModel(private val getPhotosUseCase: GetPhotosUseCase) : ViewModel() {
    fun getPhotos(albumId: Int): LiveData<List<Photo>> = liveData {
        val photosList = getPhotosUseCase.execute(albumId)
        if (photosList != null) {
            emit(photosList)
        }
    }
}