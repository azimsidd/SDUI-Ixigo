package com.thecodingshef.testixigo.divikit// 5. ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yandex.div.data.DivParsingEnvironment
import com.yandex.div.json.ParsingErrorLogger
import com.yandex.div2.DivData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject


@HiltViewModel
class FareViewModel @Inject constructor(
    private val repository: FareRepository,
) : ViewModel() {

    private val _divData = MutableStateFlow<DivData?>(null)
    val divData: StateFlow<DivData?> = _divData

    fun fetchDivData() {
        viewModelScope.launch {
            try {
                val jsonString = repository.fetchFares()
                val jsonObject = JSONObject(jsonString)
                val parsedDivData = jsonObject.asDiv2DataWithTemplates()
                _divData.value = parsedDivData
            } catch (e: Exception) {
                Log.e("viewModel", "Error fetching or parsing DivKit JSON", e)
            }
        }
    }

    fun JSONObject.asDiv2DataWithTemplates(): DivData {
        val templates = getJSONObject("templates")
        val card = getJSONObject("card")
        val environment = DivParsingEnvironment(ParsingErrorLogger.LOG)
        environment.parseTemplates(templates)
        return DivData(environment, card)
    }


}


