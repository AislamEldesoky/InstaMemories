package com.example.instamemories.data.model.photo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_photo")
data class Photo(
    @SerializedName("albumId")
    val albumId: Int,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)