package com.thecodingshef.testixigo.sdui.data.model.snippets

import com.thecodingshef.testixigo.sdui.data.model.SDUISnippets
import com.thecodingshef.testixigo.sdui.ui.components.BgColor
import kotlinx.serialization.Serializable

@Serializable
data class SpacerSnippetData(
    val height: Int = 16,
    override var bgColor: String? = null
) : SDUISnippets(), BgColor