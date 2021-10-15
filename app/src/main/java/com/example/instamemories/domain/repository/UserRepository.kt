package com.example.instamemories.domain.repository

import com.example.instamemories.data.model.user.User

interface UserRepository {

  suspend fun getUsers():List<User>
}