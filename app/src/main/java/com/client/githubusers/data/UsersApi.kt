package com.client.githubusers.data

import com.client.githubusers.data.model.UsersResponse
import retrofit2.http.GET

interface UsersApi {

    @GET("users")
    suspend fun getUsers(): List<UsersResponse>
}