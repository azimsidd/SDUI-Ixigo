package com.thecodingshef.testixigo.sdui.utils

import androidx.compose.ui.text.font.FontWeight

fun String.toFontWeight(): FontWeight {
    return when (this.lowercase()) {
        "bold" -> FontWeight.Bold
        "medium" -> FontWeight.Medium
        "light" -> FontWeight.Light
        "regular", "normal" -> FontWeight.Normal
        else -> FontWeight.Normal
    }
}