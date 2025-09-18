package com.thecodingshef.testixigo.sdui.data.model.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageData(
    val url: String? = null,
    @SerialName("content_description") val contentDescription: String? = null
)