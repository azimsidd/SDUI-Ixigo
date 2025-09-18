package com.thecodingshef.testixigo.sdui.data.repository

import com.thecodingshef.testixigo.sdui.data.api.ApiService
import com.thecodingshef.testixigo.sdui.data.model.SDUIResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SDUIRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getSDUIData(): Result<SDUIResponse> {
        return try {
            val response = apiService.getSDUIData()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}