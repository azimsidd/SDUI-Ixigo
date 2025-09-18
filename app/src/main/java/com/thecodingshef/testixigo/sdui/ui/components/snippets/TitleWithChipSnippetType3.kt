package com.thecodingshef.testixigo.sdui.ui.components.snippets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type3TitleChipSnippetData
import com.thecodingshef.testixigo.sdui.ui.components.base.SDUIChip
import com.thecodingshef.testixigo.sdui.ui.components.base.SDUIText
import com.thecodingshef.testixigo.sdui.utils.SpacerWidth
import com.thecodingshef.testixigo.sdui.utils.toColor

@Composable
fun TitleWithChipSnippetType3(
    item: Type3TitleChipSnippetData,
    clickHandler: Type3SnippetClickHandler?,
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
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = item.bgColor?.toColor() ?: Color.Transparent,
            )
            .then(paddingModifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        item.title?.let { title ->
            SDUIText(textData = title)
        }
        SpacerWidth(8.dp)
        item.chip?.let { chipData ->
            SDUIChip(chipData, onClick = {
                clickHandler?.onType3ChipClick()
            })
        }
    }
}

interface Type3SnippetClickHandler {
    fun onType3ChipClick()
}