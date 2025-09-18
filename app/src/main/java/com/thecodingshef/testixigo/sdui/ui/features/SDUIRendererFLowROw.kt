package com.thecodingshef.testixigo.sdui.ui.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.thecodingshef.testixigo.sdui.data.model.GridConfig
import com.thecodingshef.testixigo.sdui.data.model.SDUIResponse
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type1SnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type2SnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type3TitleChipSnippetData
import com.thecodingshef.testixigo.sdui.ui.components.snippets.ImageTitleSubtitleType1
import com.thecodingshef.testixigo.sdui.ui.components.snippets.ImageTitleSubtitleType2
import com.thecodingshef.testixigo.sdui.ui.components.snippets.SnippetClickHandler
import com.thecodingshef.testixigo.sdui.ui.components.snippets.TitleWithChipSnippetType3
import com.thecodingshef.testixigo.sdui.utils.toColor

@OptIn(ExperimentalLayoutApi::class) // For FlowRow
@Composable
fun SDUIRendererFlowRow(
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

        items(response.data.results) { snippetContainer -> // Renamed item to snippetContainer for clarity
            val gridConfig = snippetContainer.layoutConfig.gridConfig ?: GridConfig()
            val itemsToRender = snippetContainer.data.items

            if (gridConfig.columns > 1) { // It's a grid, use FlowRow
//                val configuration = LocalConfiguration.current
//                val screenWidthDp = configuration.screenWidthDp.dp
//                // Adjust padding calculation based on your actual surrounding padding
//                val horizontalPaddingForGrid = (16.dp) // From LazyColumn's contentPadding
//                val itemSpacing = gridConfig.spacing.dp
//                val totalSpacing = itemSpacing * (gridConfig.columns - 1)
//                val itemWidth =
//                    (screenWidthDp - (horizontalPaddingForGrid * 2) - totalSpacing) / gridConfig.columns


                val configuration = LocalConfiguration.current
                val screenWidthDp = configuration.screenWidthDp.dp

                // This is the padding of the LazyColumn itself
                val lazyColumnHorizontalPadding = 16.dp * 2 // (16.dp left + 16.dp right)

                // This is the spacing BETWEEN items in the FlowRow
                val itemSpacing = gridConfig.spacing.dp
                val totalHorizontalSpacingBetweenItems = itemSpacing * (gridConfig.columns - 1)

                // The usable width for all items in the FlowRow
                val availableWidthForItems = screenWidthDp - lazyColumnHorizontalPadding - totalHorizontalSpacingBetweenItems

                val itemWidth = availableWidthForItems / gridConfig.columns


                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                    verticalArrangement = Arrangement.spacedBy(itemSpacing), // Spacing between rows
                    maxItemsInEachRow = gridConfig.columns
                ) {
                    itemsToRender.forEach { sduiSnippet ->
                        // Apply a width to each item in the FlowRow
                        // You might want to wrap your snippet composables in a Box if they don't handle modifiers well directly
                        // or if you need to apply additional padding/alignment per cell.
                        Box(modifier = Modifier.width(itemWidth)) { // Ensure each item takes up its allocated width
                            RenderSduiSnippet(sduiSnippet, clickHandler)
                        }
                    }
                }
            } else { // It's a single column list (effectively), use Column
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(gridConfig.spacing.dp) // Use spacing if defined
                ) {
                    itemsToRender.forEach { sduiSnippet ->
                        RenderSduiSnippet(sduiSnippet, clickHandler, Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }
}

// Helper composable to reduce repetition
@Composable
private fun RenderSduiSnippet(
    sduiSnippet: Any, // Assuming SDUISnippets is the base or interface
    clickHandler: SnippetClickHandler?,
    modifier: Modifier = Modifier // Allow passing a modifier
) {
    when (sduiSnippet) {
        is Type1SnippetData -> ImageTitleSubtitleType1(
            item = sduiSnippet,
            clickHandler = clickHandler,
            modifier = modifier
        )

        is Type2SnippetData -> ImageTitleSubtitleType2(
            data = sduiSnippet,
            clickHandler = clickHandler,
            modifier = modifier
        )

        is Type3TitleChipSnippetData -> TitleWithChipSnippetType3(
            item = sduiSnippet,
            clickHandler = clickHandler,
            modifier = modifier
        )

        else -> Text("Unknown snippet type", modifier = modifier)
    }
}
