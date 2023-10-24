package com.client.githubusers.di

import android.content.Context
import com.client.githubusers.BuildConfig
import com.client.githubusers.data.UsersApi
import com.client.githubusers.data.util.OfflineInterceptor
import com.client.githubusers.data.util.OnlineInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    factory { provideOkHttpClient(appContext = androidContext(), get(), get()) }
    factory { provideRetrofit(get()) }
    single { OfflineInterceptor(appContext = androidContext()) }
    single { OnlineInterceptor() }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit
        .Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

fun provideOkHttpClient(
    appContext: Context,
    onlineInterceptor: OnlineInterceptor,
    offlineInterceptor: OfflineInterceptor
): OkHttpClient {
    val cacheSize = (5 * 1024 * 1024).toLong()
    val myCache = Cache(appContext.cacheDir, cacheSize)

    return OkHttpClient.Builder()
        .addInterceptor(offlineInterceptor)
        .addNetworkInterceptor(onlineInterceptor)
        .cache(myCache)
        .build()
}

fun provideUsersApi(retrofit: Retrofit): UsersApi = retrofit.create(UsersApi::class.java)
