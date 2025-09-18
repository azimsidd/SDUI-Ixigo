package com.thecodingshef.testixigo.sdui.ui.features.home.viewmodel// 5. ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thecodingshef.testixigo.sdui.data.repository.SDUIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: SDUIRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<SDUIUiState>(SDUIUiState.Loading)
    val uiState: StateFlow<SDUIUiState> = _uiState.asStateFlow()

    fun loadHomeFeed() {
        viewModelScope.launch {
            _uiState.value = SDUIUiState.Loading
            repository.getSDUIData()
                .onSuccess { response ->
                    _uiState.value = SDUIUiState.Success(response)
                }
                .onFailure { exception ->
                    _uiState.value = SDUIUiState.Error(exception.message ?: "Unknown error")
                }
        }
    }

    fun retry() {
        loadHomeFeed()
    }

}


