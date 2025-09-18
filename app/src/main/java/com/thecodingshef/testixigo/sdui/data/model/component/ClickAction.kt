package com.thecodingshef.testixigo.sdui.data.model.component

import kotlinx.serialization.Serializable

@Serializable
data class ClickAction(
    val type: String, // "navigate", "url", "deeplink"
    val destination: String? = null,
    val url: String? = null,
    val params: Map<String, String> = emptyMap()
)
