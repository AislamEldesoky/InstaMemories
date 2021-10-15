package com.example.instamemories.data.repository.photo.datasourceimpl

import com.example.instamemories.data.db.PhotoDao
import com.example.instamemories.data.model.photo.Photo
import com.example.instamemories.data.repository.photo.datasource.PhotoLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotoLocalDataSourceImpl (private val photoDao: PhotoDao) : PhotoLocalDataSource {
    override suspend fun getPhotosFromDB(): List<Photo> {
       return photoDao.getPhotos()
    }

    override suspend fun savePhotosToDB(photos: List<Photo>) {
      CoroutineScope(Dispatchers.IO).launch {
          photoDao.savePhotos(photos)
      }
    }

    override suspend fun clearPhotosFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            photoDao.deletePhotos()
        }
    }
}