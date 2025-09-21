package com.thecodingshef.testixigo.sdui.utils

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt

fun String?.toColor(): Color {
    return runCatching {
        this?.let { Color(it.toColorInt()) } ?: Color.Transparent
    }.getOrDefault(Color.Transparent)
}


