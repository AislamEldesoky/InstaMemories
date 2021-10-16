package com.example.instamemories.domain.usecase

import com.example.instamemories.data.model.user.User
import com.example.instamemories.domain.repository.UserRepository
import io.reactivex.Single

class GetUsersUseCase(private val userRepository: UserRepository) {

    fun execute(): Single<List<User>>? = userRepository.getUsers()
}