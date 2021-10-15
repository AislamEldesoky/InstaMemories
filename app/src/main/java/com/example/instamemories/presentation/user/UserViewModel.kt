package com.example.instamemories.presentation.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.instamemories.data.model.user.User
import com.example.instamemories.domain.usecase.GetAlbumsUseCase
import com.example.instamemories.domain.usecase.GetUsersUseCase

class UserViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val getAlbumsUseCase: GetAlbumsUseCase
) : ViewModel() {

}