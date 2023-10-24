package com.client.githubusers.di

import com.client.githubusers.data.repository.UsersRepository
import com.client.githubusers.data.repository.UsersRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<UsersRepository> { UsersRepositoryImpl(get()) }
}