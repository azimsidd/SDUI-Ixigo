package com.thecodingshef.testixigo.sdui.ui.components.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.thecodingshef.testixigo.R
import com.thecodingshef.testixigo.sdui.data.model.component.ImageData

@Composable
fun SDUIImage(imageData: ImageData, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageData.url)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_launcher_background),
        contentDescription = imageData.contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier,
    )
}