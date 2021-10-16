package com.example.instamemories.data.repository.user

import android.util.Log
import com.example.instamemories.data.model.user.User
import com.example.instamemories.data.model.user.UsersList
import com.example.instamemories.domain.repository.UserRepository
import io.reactivex.Single
import retrofit2.Response
import java.lang.Exception

class UserRepositoryImpl(private val userRemoteDataSource: UserRemoteDataSource) : UserRepository {

    override fun getUsers(): Single<List<User>> {
        return getUsersFromAPI()
    }


    fun getUsersFromAPI(): Single<List<User>> {
        lateinit var users: Single<List<User>>
        // lateinit var user: Single<User>
        try {
            val response: Single<List<User>> = userRemoteDataSource.getUsers()
            Log.i("response", response.toString())
            val body = response
            if (body != null) {
                users = body
                Log.i("body", body.toString())
            }
        } catch (exception: Exception) {
            Log.i("Err", exception.message.toString())
        }
        return users
    }

}