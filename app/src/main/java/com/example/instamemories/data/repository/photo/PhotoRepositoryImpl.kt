package com.example.instamemories.data.repository.photo

import android.util.Log
import com.example.instamemories.data.model.photo.Photo
import com.example.instamemories.data.model.photo.PhotosList
import com.example.instamemories.data.repository.photo.datasource.PhotoCacheDataSource
import com.example.instamemories.data.repository.photo.datasource.PhotoLocalDataSource
import com.example.instamemories.data.repository.photo.datasource.PhotoRemoteDataSource
import com.example.instamemories.domain.repository.PhotoRepository
import retrofit2.Response
import java.lang.Exception

class PhotoRepositoryImpl(
    private val photoRemoteDataSource: PhotoRemoteDataSource,
    private val photoLocalDataSource: PhotoLocalDataSource,
    private val photoCacheDataSource: PhotoCacheDataSource
) :
    PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return getPhotosFromCache(albumId)
    }

    suspend fun getPhotosFromAPI(albumId:Int): List<Photo> {
        lateinit var photosList: List<Photo>
        try {
            val response: Response<PhotosList> = photoRemoteDataSource.getPhotos(albumId)
            val body = response.body()
            if (body != null) {
                photosList = body
            }
        } catch (exception: Exception) {
            Log.i("Err", exception.message.toString())
        }
        return photosList
    }

    suspend fun getPhotosFromDB(albumId: Int): List<Photo> {
        lateinit var photoslist: List<Photo>
        try {
            photoslist = photoLocalDataSource.getPhotosFromDB()
        } catch (exception: Exception) {
            Log.i("Err", exception.message.toString())
        }
        if (photoslist.size > 0) {
            return photoslist
        } else {
            photoslist = getPhotosFromAPI(albumId)
            photoLocalDataSource.savePhotosToDB(photoslist)
        }
        return photoslist
    }

    suspend fun getPhotosFromCache(albumId: Int) : List<Photo>{

        lateinit var photoslist: List<Photo>
        try {
            photoslist = photoCacheDataSource.getPhotosFromCache()
        } catch (exception: Exception) {
            Log.i("Err", exception.message.toString())
        }
        if (photoslist.size > 0) {
            return photoslist
        } else {
            photoslist = getPhotosFromDB(albumId)
            photoCacheDataSource.savePhotosToCache(photoslist)
        }
        return photoslist
    }
}