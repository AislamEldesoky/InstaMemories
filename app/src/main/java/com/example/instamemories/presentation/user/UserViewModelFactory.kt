package com.example.instamemories.presentation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.instamemories.domain.usecase.GetAlbumsUseCase
import com.example.instamemories.domain.usecase.GetUsersUseCase

class UserViewModelFactory(
    private val getUsersUseCase: GetUsersUseCase,
    private val getAlbumsUseCase: GetAlbumsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(getUsersUseCase,getAlbumsUseCase) as T
    }
}