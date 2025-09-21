package com.thecodingshef.testixigo.sdui.ui.components.snippets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thecodingshef.testixigo.sdui.data.model.snippets.SpacerSnippetData
import com.thecodingshef.testixigo.sdui.utils.toColor

@Composable
fun SpacerSnippet(data: SpacerSnippetData) {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = data.bgColor.toColor())
            .height(data.height.dp)
    )
}