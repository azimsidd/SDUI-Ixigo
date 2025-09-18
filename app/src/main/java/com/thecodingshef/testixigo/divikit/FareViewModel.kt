package com.thecodingshef.testixigo.divikit// 5. ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thecodingshef.testixigo.sdui.ui.features.home.viewmodel.SDUIUiState
import com.yandex.div.data.DivParsingEnvironment
import com.yandex.div.json.ParsingErrorLogger
import com.yandex.div2.DivData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject
import javax.inject.Inject


@HiltViewModel
class FareViewModel @Inject constructor(
    private val repository: FareRepository,
) : ViewModel() {

    private val _divData = MutableStateFlow<DivData?>(null)
    val divData: StateFlow<DivData?> = _divData

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
    fun fetchDivData() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.fetchFares().onSuccess { jsonString ->
                try {
                    val jsonObject = JSONObject(jsonString)
                    val parsedDivData = jsonObject.asDiv2DataWithTemplates()
                    _divData.value = parsedDivData
                    _uiState.value = UiState.Success(parsedDivData)
                } catch (e: JSONException) {
                    _uiState.value = UiState.Error(e.message ?: "Json Error")
                }
            }.onFailure { e ->
                _uiState.value = UiState.Error(e.message ?: "Unknown Error")
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


