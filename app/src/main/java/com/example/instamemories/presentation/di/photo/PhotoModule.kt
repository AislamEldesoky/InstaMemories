package com.example.instamemories.presentation.di.photo

import com.example.instamemories.domain.usecase.GetAlbumsUseCase
import com.example.instamemories.domain.usecase.GetPhotosUseCase
import com.example.instamemories.domain.usecase.GetUsersUseCase
import com.example.instamemories.presentation.di.user.UserScope
import com.example.instamemories.presentation.photo.PhotoViewModelFactory
import com.example.instamemories.presentation.user.UserViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PhotoModule {
    @PhotoScope
    @Provides
    fun providesPhotoViewModelFactory(getPhotosUseCase: GetPhotosUseCase): PhotoViewModelFactory {
        return PhotoViewModelFactory(getPhotosUseCase)
    }
}