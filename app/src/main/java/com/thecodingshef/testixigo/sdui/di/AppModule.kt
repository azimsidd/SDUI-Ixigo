package com.thecodingshef.testixigo.sdui.di// In your AppModule or a similar Hilt module
import android.content.Context
import com.thecodingshef.testixigo.sdui.ui.features.CoilImageLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.yandex.div.core.DivConfiguration
import com.yandex.div.core.images.DivImageLoader
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDivImageLoader(@ApplicationContext context: Context): DivImageLoader {
        return CoilImageLoader(context)
    }

    @Provides
    @Singleton
    fun provideDivConfiguration1(imageLoader: DivImageLoader): DivConfiguration {
        return DivConfiguration.Builder(imageLoader).build()
    }

//    @Provides
//    @Singleton
//    fun provideDivConfiguration(@ApplicationContext context: Context): DivConfiguration {
//        // You'll need to create your own DivImageLoader implementation
//        // For example, a PicassoImageLoader as discussed previously
//        val imageLoader = CoilImageLoader(context)
//
//        return DivConfiguration.Builder(imageLoader).build()
//    }
}