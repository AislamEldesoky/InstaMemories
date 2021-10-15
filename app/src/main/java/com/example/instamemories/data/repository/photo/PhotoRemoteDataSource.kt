package com.example.instamemories.data.repository.photo

import com.example.instamemories.data.model.photo.PhotosList
import com.example.instamemories.data.model.user.UsersList
import retrofit2.Response

interface PhotoRemoteDataSource {
    suspend fun getPhotos() : Response<PhotosList>
}