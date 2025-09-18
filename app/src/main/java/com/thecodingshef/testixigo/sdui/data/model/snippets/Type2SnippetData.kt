package com.thecodingshef.testixigo.sdui.data.model.snippets

import com.thecodingshef.testixigo.sdui.data.model.SDUISnippets
import com.thecodingshef.testixigo.sdui.data.model.component.ClickAction
import com.thecodingshef.testixigo.sdui.data.model.component.ImageData
import com.thecodingshef.testixigo.sdui.data.model.component.PaddingData
import com.thecodingshef.testixigo.sdui.data.model.component.TextData
import com.thecodingshef.testixigo.sdui.ui.components.BgColor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Type2SnippetData(
    val id: String,
    val image: ImageData,
    val title: TextData,
    val subtitle: TextData? = null,
    val subtitle2: TextData,
    @SerialName("bg_color") override var bgColor: String? = null,
    @SerialName("corner_radius") val cornerRadius: Int = 8,
    @SerialName("click_action") val clickAction: ClickAction? = null,
    val padding: PaddingData? = null
) : SDUISnippets(), BgColor