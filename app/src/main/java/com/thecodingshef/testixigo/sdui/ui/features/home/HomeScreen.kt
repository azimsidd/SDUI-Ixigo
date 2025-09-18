package com.thecodingshef.testixigo.sdui.ui.features.home// 7. Composable Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thecodingshef.testixigo.sdui.ui.features.SDUIRenderer
import com.thecodingshef.testixigo.sdui.ui.features.home.viewmodel.HomeViewModel
import com.thecodingshef.testixigo.sdui.ui.features.home.viewmodel.SDUIUiState

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {

    LaunchedEffect(Unit) {
        viewModel.loadHomeFeed()
    }
    val uiState by viewModel.uiState.collectAsState()

    val clickHandler = remember { HomeScreenClickHandler(navController) }


    when (uiState) {
        is SDUIUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is SDUIUiState.Success -> {
            SDUIRenderer(
                response = (uiState as SDUIUiState.Success).data,
                clickHandler = clickHandler
            )
        }

        is SDUIUiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Error: ${(uiState as SDUIUiState.Error).message}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Button(onClick = viewModel::retry) {
                        Text("Retry")
                    }
                }
            }
        }
    }
}