package com.example.instamemories.domain.repository

import com.example.instamemories.data.model.user.User
import io.reactivex.Single

interface UserRepository {

   fun getUsers(): Single<List<User>>
}