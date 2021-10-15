package com.example.instamemories.data.repository.user

import android.util.Log
import com.example.instamemories.data.model.user.User
import com.example.instamemories.data.model.user.UsersList
import com.example.instamemories.domain.repository.UserRepository
import retrofit2.Response
import java.lang.Exception

class UserRepositoryImpl(private val userRemoteDataSource : UserRemoteDataSource) : UserRepository{

    override suspend fun getUsers(): List<User> {
        return getUsersFromAPI()
    }


    suspend fun getUsersFromAPI() : List<User>{
        lateinit var usersList : List<User>
        try {
            val response : Response<UsersList> = userRemoteDataSource.getUsers()
            val body = response.body()
            if(body!=null){
                usersList =body
            }
        }catch (exception :Exception){
            Log.i("Err",exception.message.toString())
        }
        return usersList
    }

}