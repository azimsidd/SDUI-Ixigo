package com.thecodingshef.testixigo.sdui.utils

import android.content.Context
import com.yandex.div.data.DivParsingEnvironment
import com.yandex.div.json.ParsingErrorLogger
import com.yandex.div2.DivData
import com.yandex.div2.DivData.Companion.invoke
import org.json.JSONObject

object Utils {
    fun JSONObject.asDiv2DataWithTemplates(): DivData {
        val templates = optJSONObject("templates") ?: JSONObject()
        val card = getJSONObject("card")

        val environment = DivParsingEnvironment(ParsingErrorLogger.LOG)
        environment.parseTemplates(templates)
        return DivData(environment, card)
    }
    fun readJSONObjectFromAssets(context: Context, fileName: String): JSONObject? {
        return try {
            val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            JSONObject(jsonString)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}