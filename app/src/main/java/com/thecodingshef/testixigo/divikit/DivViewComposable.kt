package com.thecodingshef.testixigo.divikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.div.DivDataTag
import com.yandex.div.core.view2.Div2View
import com.yandex.div2.DivData

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
