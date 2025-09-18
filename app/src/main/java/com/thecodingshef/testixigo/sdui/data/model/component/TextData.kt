package com.thecodingshef.testixigo.sdui.data.model.component

import kotlinx.serialization.Serializable

@Serializable
data class TextData(
    val text: String,
    val color: String? = null,
    val font: FontData? = null,
    val padding: PaddingData = PaddingData()
)