package com.example.instamemories.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.instamemories.data.model.album.Album

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAlbums(albums: List<Album>)

    @Query("DELETE FROM user_album")
    suspend fun deleteAlbums()

    @Query("SELECT * FROM user_album")
    suspend fun getAlbums():List<Album>
}