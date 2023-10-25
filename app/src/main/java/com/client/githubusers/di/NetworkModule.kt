package com.client.githubusers.di

import android.content.Context
import com.client.githubusers.BuildConfig
import com.client.githubusers.data.UsersApi
import com.client.githubusers.data.util.OfflineInterceptor
import com.client.githubusers.data.util.OnlineInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    factoryOf(::provideRetrofit)
    factoryOf(::provideOkHttpClient)

    singleOf(::OfflineInterceptor)
    singleOf(::OnlineInterceptor)
    singleOf(::provideUsersApi)
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttpClient)
        .build()
}

private fun provideOkHttpClient(
    appContext: Context,
    onlineInterceptor: OnlineInterceptor,
    offlineInterceptor: OfflineInterceptor
): OkHttpClient {
    val cacheSize = (5 * 1024 * 1024).toLong()
    val myCache = Cache(appContext.cacheDir, cacheSize)

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(offlineInterceptor)
        .addNetworkInterceptor(onlineInterceptor)
        .cache(myCache)
        .build()
}

private fun provideUsersApi(retrofit: Retrofit): UsersApi = retrofit.create(UsersApi::class.java)
