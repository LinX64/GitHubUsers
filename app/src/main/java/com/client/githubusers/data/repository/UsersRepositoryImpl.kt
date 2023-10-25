package com.client.githubusers.data.repository

import com.client.githubusers.data.UsersApi
import com.client.githubusers.data.model.UserDetailResponse
import com.client.githubusers.data.model.UserItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UsersRepositoryImpl(
    private val usersApi: UsersApi
) : UsersRepository {

    override fun getUsers(): Flow<List<UserItem>> = flow {
        val users = usersApi.getUsers()
        emit(users)
    }.flowOn(Dispatchers.IO)

    override fun getUserDetailsByName(name: String): Flow<UserDetailResponse> = flow {
        val user = usersApi.getUserDetails(name)
        emit(user)
    }.flowOn(Dispatchers.IO)
}