package com.thecodingshef.testixigo.sdui.ui.components.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.thecodingshef.testixigo.sdui.utils.SpacerWidth
import com.thecodingshef.testixigo.sdui.utils.Weight1f

@Composable
fun ToolBar(
    title: String,
    onBack: () -> Unit = {},
    endComposable: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(
                    color = androidx.compose.ui.graphics.Color.Gray,
                    RoundedCornerShape(8.dp)
                )
                .clickable {
                    onBack()
                }
                .clip(RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "back",
                Modifier.size(24.dp),
                tint = White
            )
        }

        SpacerWidth(12.dp)
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.Black,
            ),
            textAlign = TextAlign.Start,
        )
        Weight1f()
        endComposable?.let { endComposable() }

    }
}