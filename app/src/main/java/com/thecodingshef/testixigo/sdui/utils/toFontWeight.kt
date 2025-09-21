package com.thecodingshef.testixigo.sdui.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.thecodingshef.testixigo.sdui.data.model.component.PaddingData

fun String.toFontWeight(): FontWeight {
    return when (this.lowercase()) {
        "bold" -> FontWeight.Bold
        "medium" -> FontWeight.Medium
        "light" -> FontWeight.Light
        "regular", "normal" -> FontWeight.Normal
        else -> FontWeight.Normal
    }
}

fun PaddingData?.toPaddingValues(): PaddingValues {
    return this?.let { padding ->
        PaddingValues(
            top = padding.top.dp,
            bottom = padding.bottom.dp,
            start = padding.left.dp,
            end = padding.right.dp
        )
    } ?: PaddingValues()
}

