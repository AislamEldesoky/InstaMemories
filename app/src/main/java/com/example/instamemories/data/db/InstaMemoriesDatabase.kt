package com.example.instamemories.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.instamemories.data.model.album.Album
import com.example.instamemories.data.model.photo.Photo

@Database(entities = [Album::class,Photo::class],version = 1,exportSchema = false)
abstract class InstaMemoriesDatabase : RoomDatabase(){
abstract fun AlbumDao(): AlbumDao
abstract fun PhotoDao(): PhotoDao
}