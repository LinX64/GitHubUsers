package com.client.githubusers.domain

import com.client.githubusers.data.model.UserItem
import com.client.githubusers.data.model.UsersResponse

class UserSearchUseCase {

    operator fun invoke(
        query: String,
        users: List<UsersResponse>
    ): List<UserItem> {
        val usersItems = users.flatten()
        val filteredUsers = usersItems.filter { user ->
            user.login.contains(query, ignoreCase = true)
        }
        return filteredUsers
    }
}