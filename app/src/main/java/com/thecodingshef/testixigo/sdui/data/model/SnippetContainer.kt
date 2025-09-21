package com.thecodingshef.testixigo.sdui.data.model

import com.thecodingshef.testixigo.sdui.data.model.component.PaddingData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = SnippetContainerSerializer::class)
data class SnippetContainer(
    @SerialName("layoutConfig") val layoutConfig: LayoutConfig,
    val data: SnippetData
)

@Serializable
data class ScreenConfig(
    @SerialName("bgColor") val bgColor: String? = null,
    @SerialName("padding") val padding: PaddingData? = null,
)

@Serializable
data class LayoutConfig(
    @SerialName("snippetType") val snippetType: String,
    @SerialName("layoutType") val layoutType: String,
    @SerialName("sectionCount") val sectionCount: Int,
    @SerialName("gridConfig") val gridConfig: GridConfig? = null
)

@Serializable
data class SnippetData(
    val items: List<SDUISnippets> = emptyList(),
)


@Serializable
open class SDUISnippets()

@Serializable
data class GridConfig(
    val columns: Int = 2,
    val spacing: Int = 8,
    @SerialName("aspect_ratio") val aspectRatio: Float = 1.0f
)
