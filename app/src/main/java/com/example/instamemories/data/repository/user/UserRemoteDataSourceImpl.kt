package com.example.instamemories.data.repository.user

import com.example.instamemories.data.api.InstaMemoriesService
import com.example.instamemories.data.model.user.User
import com.example.instamemories.data.model.user.UsersList
import com.example.instamemories.data.repository.user.UserRemoteDataSource
import io.reactivex.Single
import retrofit2.Response

class UserRemoteDataSourceImpl(private val instaMemoriesService: InstaMemoriesService) :
    UserRemoteDataSource {
    override fun getUsers(): Single<List<User>> = instaMemoriesService.getUsers()
}