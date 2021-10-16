package com.example.instamemories.presentation.photo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.instamemories.domain.usecase.GetPhotosUseCase

class PhotoViewModelFactory (private val getPhotosUseCase: GetPhotosUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PhotoViewModel(getPhotosUseCase) as T
    }
}