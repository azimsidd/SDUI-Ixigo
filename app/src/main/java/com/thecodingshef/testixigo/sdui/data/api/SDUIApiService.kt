package com.thecodingshef.testixigo.sdui.data.api

import com.thecodingshef.testixigo.sdui.data.model.SDUIResponse
import okhttp3.ResponseBody
import retrofit2.http.GET

interface ApiService {
    @GET("sdui_data.json")
    suspend fun getSDUIData(): SDUIResponse

    @GET("divikit_sdui.json")
    suspend fun getFares(): ResponseBody

}
