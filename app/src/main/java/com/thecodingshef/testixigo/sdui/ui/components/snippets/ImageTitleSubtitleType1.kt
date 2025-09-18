package com.thecodingshef.testixigo.sdui.ui.components.snippets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type1SnippetData
import com.thecodingshef.testixigo.sdui.ui.components.base.SDUIText
import com.thecodingshef.testixigo.sdui.ui.components.base.SDUIImage
import com.thecodingshef.testixigo.sdui.utils.toColor

@Composable
fun ImageTitleSubtitleType1(
    item: Type1SnippetData,
    clickHandler: Type1SnippetClickHandler?,
    modifier: Modifier = Modifier
) {
    val paddingModifier = item.padding?.let { padding ->
        Modifier.padding(
            top = padding.top.dp,
            bottom = padding.bottom.dp,
            start = padding.left.dp,
            end = padding.right.dp
        )
    } ?: Modifier.padding(12.dp)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                clickHandler?.onType1SnippetClick(item)
            }
            .background(
                color = item.bgColor?.toColor() ?: Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
            .then(paddingModifier),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Image
            item.image?.let { image ->
                SDUIImage(
                    imageData = image,
                    modifier = Modifier.size(120.dp)
                )
            }

            // Title
            item.title?.let { title ->
                SDUIText(textData = title)
            }

            // Subtitle
            item.subtitle?.let { subtitle ->
                SDUIText(textData = subtitle)
            }
        }
    }
}

interface Type1SnippetClickHandler {
    fun onType1SnippetClick(item: Type1SnippetData)
    fun onType1TitleClick(item: Type1SnippetData)
    fun onType1SubtitleClick(item: Type1SnippetData)
}