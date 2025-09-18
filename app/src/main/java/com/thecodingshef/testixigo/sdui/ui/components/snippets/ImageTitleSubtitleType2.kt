package com.thecodingshef.testixigo.sdui.ui.components.snippets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type2SnippetData
import com.thecodingshef.testixigo.sdui.ui.components.base.SDUIText
import com.thecodingshef.testixigo.sdui.ui.components.base.SDUIImage
import com.thecodingshef.testixigo.sdui.utils.toColor

@Composable
fun ImageTitleSubtitleType2(
    data: Type2SnippetData,
    clickHandler: SnippetClickHandler?,
    modifier: Modifier = Modifier
) {
    ImageTitleSubtitleType2Card(
        cardData = data,
        onClick = {
            data.clickAction?.let { action ->
                // handleClickAction(action)
            }
        },
        modifier
    )
}

@Composable
fun ImageTitleSubtitleType2Card(
    cardData: Type2SnippetData,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val paddingModifier = cardData.padding?.let { padding ->
        Modifier.padding(
            top = padding.top.dp,
            bottom = padding.bottom.dp,
            start = padding.left.dp,
            end = padding.right.dp
        )
    } ?: Modifier.padding(8.dp)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(cardData.cornerRadius.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardData.bgColor?.toColor() ?: Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = paddingModifier
        ) {

            SDUIImage(
                imageData = cardData.image,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            SDUIText(textData = cardData.title)

            cardData.subtitle?.let { subtitle ->
                Spacer(modifier = Modifier.height(4.dp))
                SDUIText(textData = subtitle)
            }

            Spacer(modifier = Modifier.height(8.dp))

            SDUIText(textData = cardData.subtitle2)
        }
    }
}

interface Type2SnippetClickHandler {
    fun onType2ImageClick(item: Type2SnippetData)
    fun onType2SubtitleClick(item: Type2SnippetData)
}