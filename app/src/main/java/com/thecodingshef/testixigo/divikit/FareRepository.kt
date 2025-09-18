package com.thecodingshef.testixigo.divikit

import com.thecodingshef.testixigo.sdui.data.api.ApiService
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FareRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun fetchFares(): Result<String> {
        return try {
            val response = apiService.getFares()
            Result.success(response.string())
        } catch (e: IOException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}