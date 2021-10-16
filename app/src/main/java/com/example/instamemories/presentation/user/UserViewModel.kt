package com.example.instamemories.presentation.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.instamemories.data.model.album.Album
import com.example.instamemories.data.model.user.User
import com.example.instamemories.domain.usecase.GetAlbumsUseCase
import com.example.instamemories.domain.usecase.GetUsersUseCase

class UserViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val getAlbumsUseCase: GetAlbumsUseCase
) : ViewModel() {
    fun getUser(): LiveData<User> = liveData {
        val userList = getUsersUseCase.execute()
        if (userList != null) {
            emit(userList.get(4))
        }
    }

    fun getUserAlbums(): LiveData<List<Album>> = liveData {
        val albumsList = getAlbumsUseCase.execute()
        if (albumsList != null) {
            emit(albumsList)
        }
    }
}