package com.example.instamemories.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.instamemories.data.model.album.Album

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun saveAlbums(albums: List<Album>)

    @Query("DELETE FROM user_album")
     fun deleteAlbums()

    @Query("SELECT * FROM user_album")
     fun getAlbums():List<Album>
}