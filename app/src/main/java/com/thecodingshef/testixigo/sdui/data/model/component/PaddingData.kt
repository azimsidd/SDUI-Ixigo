package com.thecodingshef.testixigo.sdui.data.model.component

import kotlinx.serialization.Serializable

@Serializable
data class PaddingData(
    val top: Int = 0,
    val bottom: Int = 0,
    val left: Int = 0,
    val right: Int = 0
)