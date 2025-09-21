package com.thecodingshef.testixigo.sdui.ui.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.thecodingshef.testixigo.sdui.data.model.GridConfig
import com.thecodingshef.testixigo.sdui.data.model.SDUIResponse
import com.thecodingshef.testixigo.sdui.data.model.SDUISnippets
import com.thecodingshef.testixigo.sdui.data.model.snippets.SpacerSnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type1SnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type2SnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type3TitleChipSnippetData
import com.thecodingshef.testixigo.sdui.ui.components.snippets.ImageTitleSubtitleType1
import com.thecodingshef.testixigo.sdui.ui.components.snippets.ImageTitleSubtitleType2
import com.thecodingshef.testixigo.sdui.ui.components.snippets.SnippetClickHandler
import com.thecodingshef.testixigo.sdui.ui.components.snippets.SpacerSnippet
import com.thecodingshef.testixigo.sdui.ui.components.snippets.TitleWithChipSnippetType3
import com.thecodingshef.testixigo.sdui.utils.toColor
import com.thecodingshef.testixigo.sdui.utils.toPaddingValues

@Composable
fun SDUIRenderer(
    response: SDUIResponse,
    clickHandler: SnippetClickHandler? = null
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(response.data?.screenConfig?.bgColor?.toColor() ?: Color.White),
        contentPadding = response.data?.screenConfig?.padding.toPaddingValues(),
    ) {
        items(response.data?.results.orEmpty()) { item ->
            val gridConfig = item.layoutConfig.gridConfig ?: GridConfig()
            SnippetGrid(
                columns = gridConfig.columns.coerceAtLeast(1),
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
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = Modifier
            .heightIn(max = 2000.dp)
            .fillMaxWidth(),
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

                is SpacerSnippetData -> {
                    SpacerSnippet(item)
                }

                else -> {
                    Text("Unknown snippet type")
                }
            }
        }
    }

}

@Composable
fun UiGrid(response: SDUIResponse, clickHandler: SnippetClickHandler?) {
    val flatSnippets: List<SnippetWithLayout>? = response.data?.results?.flatMap { container ->
        container.data.items.map { snippet ->
            SnippetWithLayout(
                snippet = snippet,
                // spanCount = container.layoutConfig.spanCount
            )
        }
    }
    flatSnippets?.let {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(flatSnippets, span = { GridItemSpan(it.spanCount) }) { itemWithLayout ->
                when (val item = itemWithLayout.snippet) {
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

data class SnippetWithLayout(
    val snippet: SDUISnippets,
    val spanCount: Int = 1
)


