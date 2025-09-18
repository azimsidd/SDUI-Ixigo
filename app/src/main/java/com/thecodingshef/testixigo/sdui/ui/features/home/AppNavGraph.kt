package com.thecodingshef.testixigo.sdui.ui.features.home

import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thecodingshef.testixigo.sdui.ui.features.FaresScreen
import com.yandex.div.core.view2.Div2View

@Composable
fun AppNavGraph(
    div2View: Div2View,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = ScreenRoutes.CHEAP_FARES.route) {

        // this screen is designed using custom sdui framework
        composable(ScreenRoutes.HOME.route) {
            HomeScreen(
                navController = navController
            )

            // SDUIScreenMock()
        }
        // this screen is designed using DIVIKIT sdui framework
        composable(ScreenRoutes.CHEAP_FARES.route) {
            FaresScreen(div2View = div2View)
        }
        composable(ScreenRoutes.FARE_DETAIL.route) {
            FareDetail(onBack = {
                navController.popBackStack()
            })
        }
    }
}
