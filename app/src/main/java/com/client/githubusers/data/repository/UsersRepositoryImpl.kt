package com.client.githubusers.data.repository

import com.client.githubusers.data.UsersApi
import com.client.githubusers.data.model.UsersResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UsersRepositoryImpl(
    private val usersApi: UsersApi
) : UsersRepository {

    override fun getUsers(): Flow<List<UsersResponse>> = flow {
        val users = usersApi.getUsers()
        emit(users)
    }
}