package com.thecodingshef.testixigo.sdui.ui.components.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thecodingshef.testixigo.sdui.data.model.component.ChipData
import com.thecodingshef.testixigo.sdui.utils.toColor


@Composable
fun SDUIChip(
    chipData: ChipData,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        color = chipData.bgColor?.toColor() ?: Color.Transparent,
        border = BorderStroke(
            width = 1.dp,
            color = chipData.borderColor?.toColor() ?: Color.Gray
        )
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            chipData.icon?.let {
                Text(text = ">", fontSize = 12.sp) // Dropdown icon placeholder
            }

            chipData.text?.let { title ->
                SDUIText(textData = title)
            }
        }
    }
}