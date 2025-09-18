package com.thecodingshef.testixigo.sdui.ui.features

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import coil3.imageLoader
import coil3.request.ImageRequest
import coil3.request.target
import com.yandex.div.core.images.DivImageDownloadCallback
import com.yandex.div.core.images.DivImageLoader
import com.yandex.div.core.images.LoadReference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoilImageLoader(private val context: Context) : DivImageLoader {

    private val imageLoader = context.imageLoader

    override fun loadImage(
        imageUrl: String,
        callback: DivImageDownloadCallback
    ): LoadReference {
        val request = ImageRequest.Builder(context)
            .data(imageUrl)
            .target(
                onSuccess = { drawable ->
                    // Cast the drawable to a BitmapDrawable before passing it to onSuccess
                    if (drawable is BitmapDrawable) {
                        callback.onSuccess(drawable)
                    } else {
                        // Handle cases where the drawable is not a bitmap drawable
                        callback.onError()
                    }
                },
                onError = {
                    callback.onError()
                }
            )
            .build()

        val job = CoroutineScope(Dispatchers.IO).launch {
            val disposable = imageLoader.enqueue(request)
            if (disposable.isDisposed) {
                callback.onError()
            }
        }

        return LoadReference { job.cancel() }
    }

    override fun loadImageBytes(
        imageUrl: String,
        callback: DivImageDownloadCallback
    ): LoadReference {
        // Not implemented as DivKit doesn't require this for most cases.
        // If needed, you would use Coil to load a byte array.
        callback.onError()
        return LoadReference {
            // No-op
        }
    }

    override fun loadImage(
        imageUrl: String,
        imageView: ImageView
    ): LoadReference {
        val request = ImageRequest.Builder(context)
            .data(imageUrl)
            .target(imageView)
            .build()

        val job = CoroutineScope(Dispatchers.Main).launch {
            imageLoader.enqueue(request)
        }

        return LoadReference { job.cancel() }
    }
}