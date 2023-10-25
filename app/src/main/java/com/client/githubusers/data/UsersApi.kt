package com.client.githubusers.data

import com.client.githubusers.data.model.UserDetailResponse
import com.client.githubusers.data.model.UserItem
import retrofit2.http.GET

interface UsersApi {

    @GET("users")
    suspend fun getUsers(): List<UserItem>

    @GET("users/{name}")
    suspend fun getUserDetailsByName(name: String): UserDetailResponse
}