package com.example.instamemories.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.instamemories.data.model.photo.Photo

@Dao
interface PhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePhotos(photos: List<Photo>)

    @Query("DELETE FROM user_photo")
    suspend fun deletePhotos()

    @Query("SELECT * FROM user_photo")
    suspend fun getPhotos() : List<Photo>
}