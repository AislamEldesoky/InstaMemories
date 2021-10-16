package com.example.instamemories.presentation.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.instamemories.data.model.album.Album
import com.example.instamemories.data.model.album.AlbumsList
import com.example.instamemories.data.model.user.User
import com.example.instamemories.domain.usecase.GetAlbumsUseCase
import com.example.instamemories.domain.usecase.GetUsersUseCase
import io.reactivex.Single

class UserViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val getAlbumsUseCase: GetAlbumsUseCase
) : ViewModel() {
    fun getUser(): Single<List<User>>? = getUsersUseCase.execute()


    fun getUserAlbums(userId: Int): Single<AlbumsList>? = getAlbumsUseCase.execute(userId)

}
