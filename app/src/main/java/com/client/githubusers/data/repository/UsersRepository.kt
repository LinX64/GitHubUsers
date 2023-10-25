package com.client.githubusers.data.repository

import com.client.githubusers.data.model.UserItem
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getUsers(): Flow<List<UserItem>>
}
