package com.thecodingshef.testixigo.sdui.data.model.snippets

import com.thecodingshef.testixigo.sdui.data.model.GridConfig
import com.thecodingshef.testixigo.sdui.data.model.SDUISnippets
import com.thecodingshef.testixigo.sdui.data.model.component.ChipData
import com.thecodingshef.testixigo.sdui.data.model.component.ClickAction
import com.thecodingshef.testixigo.sdui.data.model.component.PaddingData
import com.thecodingshef.testixigo.sdui.ui.components.BgColor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Type2SnippetData1(
    override var bgColor: String? = null,
    val padding: PaddingData? = null,
    @SerialName("click_action") val clickAction: ClickAction? = null,
    val chip: ChipData? = null,
    @SerialName("grid_config") val gridConfig: GridConfig? = null,
    val cards: List<Type2SnippetData> = emptyList()
) : SDUISnippets(), BgColor
