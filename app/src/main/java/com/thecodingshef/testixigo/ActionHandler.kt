package com.thecodingshef.testixigo

import com.yandex.div.core.DivActionHandler
import com.yandex.div.core.DivViewFacade
import com.yandex.div.json.expressions.ExpressionResolver
import com.yandex.div2.DivAction

class ActionHandler(
    val onNavigate: (route: String) -> Unit
) : DivActionHandler() {

    override fun handleAction(
        action: DivAction, view: DivViewFacade, resolver: ExpressionResolver
    ): Boolean {

        val url = action.url?.evaluate(resolver)?.toString()
        url?.let {
            if (url.startsWith("screen://")) {
                val screenRoute = url.removePrefix("screen://")
                onNavigate(screenRoute)
                return true
            }
        }
        return super.handleAction(action, view, resolver)
    }
}