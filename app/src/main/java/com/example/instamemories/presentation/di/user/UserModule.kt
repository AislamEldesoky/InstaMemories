package com.example.instamemories.presentation.di.user

import com.example.instamemories.domain.usecase.GetAlbumsUseCase
import com.example.instamemories.domain.usecase.GetUsersUseCase
import com.example.instamemories.presentation.user.UserViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class UserModule  {

    @UserScope
    @Provides
    fun providesUserViewModelFactory(getUsersUseCase: GetUsersUseCase,getAlbumsUseCase: GetAlbumsUseCase):UserViewModelFactory{
        return UserViewModelFactory(getUsersUseCase,getAlbumsUseCase)
    }
}