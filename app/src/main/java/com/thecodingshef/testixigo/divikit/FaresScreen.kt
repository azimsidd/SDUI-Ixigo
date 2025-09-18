package com.thecodingshef.testixigo.divikit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.yandex.div.core.view2.Div2View

@Composable
fun FaresScreen(
    viewmodel: FareViewModel = hiltViewModel(),
    div2View: Div2View
) {
    val uiState by viewmodel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewmodel.fetchDivData()
    }
    when (uiState) {
        is UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is UiState.Success -> {
            DivViewComposable(
                div2View,
                (uiState as UiState.Success).data
            )
        }

        is UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Error: ${(uiState as UiState.Error).message}",
                    style = MaterialTheme.typography.bodyMedium
                )

            }
        }
    }
}






