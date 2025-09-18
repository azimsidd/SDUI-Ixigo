package com.thecodingshef.testixigo.sdui.data.model.component

import kotlinx.serialization.Serializable

@Serializable
data class FontData(
    val size: Int,
    val weight: String
)