package com.client.githubusers.di

import com.client.githubusers.data.repository.UsersRepository
import com.client.githubusers.data.repository.UsersRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::UsersRepositoryImpl) { bind<UsersRepository>() }
}