package com.example.instamemories.data.repository.photo

import android.util.Log
import com.example.instamemories.data.model.photo.Photo
import com.example.instamemories.data.model.photo.PhotosList
import com.example.instamemories.data.model.user.User
import com.example.instamemories.data.model.user.UsersList
import com.example.instamemories.domain.repository.PhotoRepository
import retrofit2.Response
import java.lang.Exception

class PhotoRepositoryImpl(private val photoRemoteDataSource: PhotoRemoteDataSource) :
    PhotoRepository {
    override suspend fun getPhotos(): List<Photo> {
        return getPhotosFromAPI()
    }

    suspend fun getPhotosFromAPI(): List<Photo> {
        lateinit var photosList: List<Photo>
        try {
            val response: Response<PhotosList> = photoRemoteDataSource.getPhotos()
            val body = response.body()
            if (body != null) {
                photosList = body
            }
        } catch (exception: Exception) {
            Log.i("Err", exception.message.toString())
        }
        return photosList
    }
}