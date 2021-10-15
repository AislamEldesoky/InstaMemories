package com.example.instamemories.domain.usecase

import com.example.instamemories.data.model.user.User
import com.example.instamemories.domain.repository.UserRepository

class GetUsersUseCase (private val userRepository: UserRepository) {

    suspend fun execute():List<User>? = userRepository.getUsers()
}