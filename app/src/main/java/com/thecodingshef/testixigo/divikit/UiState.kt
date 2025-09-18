package com.thecodingshef.testixigo.divikit

import com.yandex.div2.DivData

sealed class UiState {
    data object Loading : UiState()
    data class Success(val data: DivData) : UiState()
    data class Error(val message: String) : UiState()
}