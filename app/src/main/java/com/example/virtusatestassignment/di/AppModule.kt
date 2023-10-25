package com.example.virtusatestassignment.di

import com.example.virtusatestassignment.common.Constants
import com.example.virtusatestassignment.data.remote.PostJhoneApi
import com.example.virtusatestassignment.data.repository.PostJhoneRepositoryImpl
import com.example.virtusatestassignment.domain.repository.PostJhoneRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): PostJhoneApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostJhoneApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: PostJhoneApi): PostJhoneRepository {
        return PostJhoneRepositoryImpl(api)
    }
}