package com.example.myapplication.di

import com.example.myapplication.data.ApiService
import com.example.myapplication.data.NetworkConstants.Companion.BASE_URL
import com.example.myapplication.data.repository.NetworkRepositoryImpl
import com.example.myapplication.domain.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesApiService(): ApiService =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)


    @Provides
    fun providesNetworkRepository(): NetworkRepository = NetworkRepositoryImpl(providesApiService())
}