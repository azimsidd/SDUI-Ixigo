package com.thecodingshef.testixigo.sdui.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SDUIResponse(
    val status: Status,
    val data: ScreenData
)

@Serializable
data class Status(
    val code: Int,
    val message: String
)
