package com.thecodingshef.testixigo.sdui.ui.features.home// 7. Composable Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thecodingshef.testixigo.sdui.ui.features.SDUIRenderer
import com.thecodingshef.testixigo.sdui.ui.features.home.viewmodel.HomeViewModel
import com.thecodingshef.testixigo.sdui.ui.features.home.viewmodel.SDUIUiState
import com.thecodingshef.testixigo.sdui.utils.SpacerHeight

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {

    LaunchedEffect(Unit) {
        viewModel.loadHomeFeed(isMock = false)
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
            //SduiGridTest()
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

data class GridItem(
    val title: String,
    val subtitle: String,
    val span: Int = 1 // default span = 1
)

@Composable
fun SduiGridTest(column: Int = 2) {
    val items = listOf(
        GridItem("Header", "Full width", span = column), // spans all columns
        GridItem("Item 1", "Normal", span = 1),
        GridItem("Item 2", "Takes 2 cols", span = 2),
        GridItem("Item 3", "Normal", span = 1),
        GridItem("Item 4", "Normal", span = 1),
        GridItem("Item 5", "Normal", span = 1),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(column),
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = items,
            span = { GridItemSpan(it.span) }
        ) { item ->
            Column(
                modifier = Modifier
                    .background(Color.Red)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(item.title)
                SpacerHeight(16.dp)
                Text(item.subtitle)
            }
        }
    }
}
