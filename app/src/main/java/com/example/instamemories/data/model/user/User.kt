package com.example.instamemories.data.model.user
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("address")
    val address: Address,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
)