package com.example.instamemories.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.instamemories.data.db.AlbumDao
import com.example.instamemories.data.db.InstaMemoriesDatabase
import com.example.instamemories.data.db.PhotoDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideInstaMemoriesDatabase(context: Context): InstaMemoriesDatabase {
        return Room.databaseBuilder(
            context,
            InstaMemoriesDatabase::class.java,
            "InstaMemoriesClient"
        ).build()
    }

    @Singleton
    @Provides
    fun providePhotoDao(instaMemoriesDatabase: InstaMemoriesDatabase): PhotoDao {
        return instaMemoriesDatabase.PhotoDao()
    }

    @Singleton
    @Provides
    fun provideAlbumDao(instaMemoriesDatabase: InstaMemoriesDatabase): AlbumDao {
        return instaMemoriesDatabase.AlbumDao()
    }
}
