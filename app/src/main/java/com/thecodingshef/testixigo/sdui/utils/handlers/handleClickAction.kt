package com.thecodingshef.testixigo.sdui.utils.handlers

import androidx.navigation.NavHostController
import com.thecodingshef.testixigo.sdui.data.model.component.ClickAction

fun handleClickAction(navController: NavHostController, action: ClickAction?) {
    when (action?.type) {
        "navigate" -> {
            action.destination?.let {
                navController.navigate(action.destination)
            }

            println("Navigate to: ${action.destination}")
        }

        "url" -> {
            println("Open URL: ${action.url}")
        }

        "deeplink" -> {
            println("Open deeplink: ${action.destination}")
        }

        else -> {
            println("Unknown action type: ${action?.type}")
        }
    }
}