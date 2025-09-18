package com.thecodingshef.testixigo.sdui.ui.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.thecodingshef.testixigo.sdui.ui.components.base.ToolBar

@Composable
fun FareDetail(onBack: () -> Unit) {
    Box(modifier = Modifier
        .background(Color.White)
        .fillMaxSize()) {
        ToolBar("Fare", onBack)
    }
}