package com.example.instamemories.data.repository.user

import com.example.instamemories.data.model.user.UsersList
import retrofit2.Response

interface UserRemoteDataSource {
    suspend fun getUsers() :Response<UsersList>
}