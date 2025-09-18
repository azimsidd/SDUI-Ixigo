package com.thecodingshef.testixigo.sdui.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.thecodingshef.testixigo.sdui.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
    }


    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder().baseUrl("https://cdn.thecodingshef.in/")
            .addConverterFactory(json.asConverterFactory(contentType)).build()
    }

    @Provides
    @Singleton
    fun provideSDUIApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}
