package com.thecodingshef.testixigo.sdui.ui.features.home.viewmodel

import com.thecodingshef.testixigo.sdui.data.model.SDUIResponse

sealed class SDUIUiState {
    data object Loading : SDUIUiState()
    data class Success(val data: SDUIResponse) : SDUIUiState()
    data class Error(val message: String) : SDUIUiState()
}