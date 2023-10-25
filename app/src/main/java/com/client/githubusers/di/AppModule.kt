package com.client.githubusers.di

import com.client.githubusers.domain.UserSearchUseCase
import com.client.githubusers.ui.views.users.UserSearchViewModel
import com.client.githubusers.ui.views.userDetail.UserDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::UserSearchViewModel)
    viewModelOf(::UserDetailViewModel)

    singleOf(::UserSearchUseCase)
}