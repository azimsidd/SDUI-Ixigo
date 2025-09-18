package com.thecodingshef.testixigo.sdui.ui.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.thecodingshef.testixigo.sdui.data.model.GridConfig
import com.thecodingshef.testixigo.sdui.data.model.SDUIResponse
import com.thecodingshef.testixigo.sdui.data.model.SDUISnippets
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type1SnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type2SnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type3TitleChipSnippetData
import com.thecodingshef.testixigo.sdui.ui.components.snippets.ImageTitleSubtitleType1
import com.thecodingshef.testixigo.sdui.ui.components.snippets.ImageTitleSubtitleType2
import com.thecodingshef.testixigo.sdui.ui.components.snippets.SnippetClickHandler
import com.thecodingshef.testixigo.sdui.ui.components.snippets.TitleWithChipSnippetType3
import com.thecodingshef.testixigo.sdui.utils.toColor

@Composable
fun SDUIRenderer(
    response: SDUIResponse,
    clickHandler: SnippetClickHandler? = null
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(response.data.bgColor?.toColor() ?: Color.White),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Header
        response.data.header?.let { header ->
            item {
                Text(
                    text = header.title,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
        }


        items(response.data.results) { item ->
            val gridConfig = item.layoutConfig.gridConfig ?: GridConfig()
            SnippetGrid(
                columns = gridConfig.columns,
                spacing = gridConfig.spacing,
                snippets = item.data.items,
                clickHandler = clickHandler
            )
        }
    }
}


@Composable
fun SnippetGrid(
    columns: Int,
    spacing: Int,
    snippets: List<SDUISnippets>,
    clickHandler: SnippetClickHandler? = null
) {
    val gridHeight = calculateGridHeight(
        snippets.size,
        columns
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(gridHeight)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(spacing.dp),
            horizontalArrangement = Arrangement.spacedBy(spacing.dp)
        ) {

            items(snippets) { item ->
                when (item) {
                    is Type1SnippetData -> {
                        ImageTitleSubtitleType1(item = item, clickHandler)
                    }

                    is Type2SnippetData -> {
                        ImageTitleSubtitleType2(data = item, clickHandler)
                    }

                    is Type3TitleChipSnippetData -> {
                        TitleWithChipSnippetType3(item = item, clickHandler)
                    }

                    else -> {
                        Text("Unknown snippet type")
                    }
                }
            }
        }
    }
}

@Composable
fun calculateGridHeight(itemCount: Int, columns: Int): Dp {
    val rows = (itemCount + columns - 1) / columns // Round up
    val rowHeight = 200.dp // Approximate height per row; adjust as needed
    return rowHeight * rows
}
