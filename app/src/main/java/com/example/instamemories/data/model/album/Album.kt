package com.example.instamemories.data.model.album
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "user_album")
data class Album(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)