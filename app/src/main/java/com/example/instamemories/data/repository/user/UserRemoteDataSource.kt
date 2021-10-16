package com.example.instamemories.data.repository.user

import com.example.instamemories.data.model.user.User
import com.example.instamemories.data.model.user.UsersList
import io.reactivex.Single
import retrofit2.Response

interface UserRemoteDataSource {
    fun getUsers() : Single<List<User>>
}