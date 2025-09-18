package com.thecodingshef.testixigo.divikit

import com.thecodingshef.testixigo.sdui.data.api.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FareRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun fetchFares(): String {
        val response = apiService.getFares()
        return response.string()
    }

}