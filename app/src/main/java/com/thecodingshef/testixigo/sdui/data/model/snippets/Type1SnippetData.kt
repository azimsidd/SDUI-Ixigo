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
data class Type1SnippetData(
    val title: TextData? = null,
    val subtitle: TextData? = null,
    val image: ImageData? = null,
    val padding: PaddingData? = null,
    @SerialName("clickAction") val clickAction: ClickAction? = null,
    override var bgColor: String? = null
) : SDUISnippets(), BgColor
