package com.thecodingshef.testixigo.sdui.data.model.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChipData(
    val text: TextData? = null,
    val color: String? = null,
    @SerialName("bg_color") val bgColor: String? = null,
    @SerialName("border_color") val borderColor: String? = null,
    val icon: String? = null,
    @SerialName("is_selected") val isSelected: Boolean = false,
    @SerialName("click_action") val clickAction: ClickAction? = null
)