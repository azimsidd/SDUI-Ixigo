package com.thecodingshef.testixigo.sdui.data.model// ================================
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ScreenData(
    val header: Header? = null,
    @SerialName("bgColor") val bgColor: String? = null,
    val results: List<SnippetContainer> = emptyList()
)

@Serializable
data class Header(
    val title: String
)