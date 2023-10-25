package com.client.githubusers.domain

import com.client.githubusers.data.model.UserItem

class UserSearchUseCase {

    operator fun invoke(
        query: String,
        users: List<UserItem>
    ): List<UserItem> {
        val filteredUsers = users.filter { user ->
            user.login.contains(query, ignoreCase = true)
        }
        return filteredUsers
    }
}