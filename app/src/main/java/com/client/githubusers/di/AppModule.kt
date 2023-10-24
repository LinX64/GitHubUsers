package com.client.githubusers.di

import com.client.githubusers.ui.users.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { UsersViewModel(get()) }
}