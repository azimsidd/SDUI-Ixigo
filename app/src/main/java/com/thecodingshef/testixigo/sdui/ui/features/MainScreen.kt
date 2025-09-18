package com.thecodingshef.testixigo.sdui.ui.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.thecodingshef.testixigo.divikit.FareViewModel
import com.yandex.div.DivDataTag
import com.yandex.div.core.view2.Div2View
import com.yandex.div2.DivData

@Composable
fun FaresScreen(
    viewmodel: FareViewModel = hiltViewModel(),
    div2View: Div2View
) {
    val divData by viewmodel.divData.collectAsState()
    LaunchedEffect(Unit) {
        viewmodel.fetchDivData()
    }
    DivViewComposable(
        div2View,
        divData
    )
}

@Composable
fun DivViewComposable(
    div2View: Div2View,
    divData: DivData?,
    tag: String = ""
) {
    AndroidView(
        factory = { div2View },
        update = { view ->
            divData?.let { view.setData(it, DivDataTag("screen_$tag")) }
        },
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
}






