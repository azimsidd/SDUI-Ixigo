package com.thecodingshef.testixigo.sdui.ui.features.home

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thecodingshef.testixigo.divikit.FaresScreen
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
        composable(
            ScreenRoutes.FARE_DETAIL.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Up, // slide from bottom
                    animationSpec = tween(200)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Down, // slide to bottom
                    animationSpec = tween(150)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Up,
                    animationSpec = tween(200)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Down,
                    animationSpec = tween(200)
                )
            }

        ) {
            FareDetail(onBack = {
                navController.popBackStack()
            })
        }
    }
}
