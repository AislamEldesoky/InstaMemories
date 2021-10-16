package com.example.instamemories.presentation.di.core

import com.example.instamemories.domain.repository.AlbumRepository
import com.example.instamemories.domain.repository.PhotoRepository
import com.example.instamemories.domain.repository.UserRepository
import com.example.instamemories.domain.usecase.GetAlbumsUseCase
import com.example.instamemories.domain.usecase.GetPhotosUseCase
import com.example.instamemories.domain.usecase.GetUsersUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository) : GetUsersUseCase{
        return GetUsersUseCase(userRepository)
    }
    @Provides
    fun provideGetPhotosUseCase(photoRepository: PhotoRepository) : GetPhotosUseCase{
        return GetPhotosUseCase(photoRepository)
    }
    @Provides
    fun provideGetAlbumUseCase(albumRepository: AlbumRepository) : GetAlbumsUseCase{
        return GetAlbumsUseCase(albumRepository)
    }
}