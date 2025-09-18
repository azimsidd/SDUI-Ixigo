package com.thecodingshef.testixigo.sdui.ui.components.base

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thecodingshef.testixigo.sdui.data.model.component.TextData
import com.thecodingshef.testixigo.sdui.utils.toColor
import com.thecodingshef.testixigo.sdui.utils.toFontWeight

@Composable
fun SDUIText(
    textData: TextData,
    modifier: Modifier = Modifier
) {
    val paddingModifier = textData.padding.let { padding ->
        modifier.padding(
            top = padding.top.dp,
            bottom = padding.bottom.dp,
            start = padding.left.dp,
            end = padding.right.dp
        )
    }
    Text(
        text = textData.text,
        style = TextStyle(
            fontSize = (textData.font?.size ?: 14).sp,
            fontWeight = textData.font?.weight?.toFontWeight() ?: FontWeight.Normal,
            color = textData.color?.toColor() ?: Color.Black
        ),
        modifier = paddingModifier
    )
}