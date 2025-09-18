package com.thecodingshef.testixigo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thecodingshef.testixigo.sdui.ui.features.home.AppNavGraph
import com.thecodingshef.testixigo.ui.theme.TestIxigoTheme
import com.yandex.div.core.Div2Context
import com.yandex.div.core.DivConfiguration
import com.yandex.div.core.view2.Div2View
import com.yandex.div.picasso.PicassoDivImageLoader
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val imageLoader = PicassoDivImageLoader(this)
        val configuration = DivConfiguration.Builder(imageLoader)
            .actionHandler(ActionHandler { route ->
                navController.navigate(route)
            })
            .build()

        val div2View = Div2View(
            Div2Context(
                baseContext = this,
                configuration = configuration,
                lifecycleOwner = this,
                themeId = 0
            )
        )

        setContent {
            navController = rememberNavController()
            TestIxigoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavGraph(div2View, navController)
                    }
                }
            }
        }

    }
}





















