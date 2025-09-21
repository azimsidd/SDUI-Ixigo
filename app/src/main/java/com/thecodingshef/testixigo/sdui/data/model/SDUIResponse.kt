package com.thecodingshef.testixigo.sdui.data.model

import com.thecodingshef.testixigo.sdui.data.model.component.ChipData
import com.thecodingshef.testixigo.sdui.data.model.component.ClickAction
import com.thecodingshef.testixigo.sdui.data.model.component.FontData
import com.thecodingshef.testixigo.sdui.data.model.component.ImageData
import com.thecodingshef.testixigo.sdui.data.model.component.PaddingData
import com.thecodingshef.testixigo.sdui.data.model.component.TextData
import com.thecodingshef.testixigo.sdui.data.model.snippets.SpacerSnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type1SnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type2SnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type3TitleChipSnippetData
import kotlinx.serialization.Serializable

@Serializable
data class SDUIResponse(
    val status: Status? = null,
    val data: ScreenData? = null
) {

    fun getMockData(): SDUIResponse {
        return SDUIResponse(
            status = Status(200, "SUCCESS"),
            data = ScreenData(
                screenConfig = ScreenConfig(
                    bgColor = "#F8F8F8",
                    padding = PaddingData(12, 12, 12, 12)
                ),
                results = listOf(
                    SnippetContainer(
                        layoutConfig = LayoutConfig(
                            snippetType = "image_title_subtitle_type_1",
                            layoutType = "grid",
                            sectionCount = 1,
                            gridConfig = GridConfig(columns = 2, spacing = 12),
                        ),
                        data = SnippetData(
                            items = listOf(
                                Type1SnippetData(
                                    bgColor = "#FFFFFF",
                                    title = TextData(
                                        text = "Bathindaaa",
                                        color = "#000000",
                                        font = FontData(18, "bold")
                                    ),
                                    subtitle = TextData(
                                        text = "Thu, 25 Sep",
                                        color = "#666666",
                                        font = FontData(14, "regular")
                                    ),
                                    padding = PaddingData(16, 16, 16, 16)
                                ),
                                Type1SnippetData(
                                    bgColor = "#FFFFFF",
                                    title = TextData(
                                        text = "Bathinda",
                                        color = "#000000",
                                        font = FontData(18, "bold")
                                    ),
                                    subtitle = TextData(
                                        text = "Thu, 25 Sep",
                                        color = "#666666",
                                        font = FontData(14, "regular")
                                    ),
                                    padding = PaddingData(16, 16, 16, 16)
                                ),
                            )
                        )
                    ),
                    SnippetContainer(
                        layoutConfig = LayoutConfig(
                            snippetType = "spacer_snippet",
                            layoutType = "grid",
                            sectionCount = 1,
                            gridConfig = GridConfig(columns = 1, spacing = 12),
                        ),
                        data = SnippetData(
                            items = listOf(
                                SpacerSnippetData(
                                    height = 16,
                                )
                            )
                        )
                    ),
                    SnippetContainer(
                        layoutConfig = LayoutConfig(
                            snippetType = "title_chip_type_3",
                            layoutType = "grid",
                            sectionCount = 1,
                            gridConfig = GridConfig(columns = 1, spacing = 12),
                        ),
                        data = SnippetData(
                            items = listOf(
                                Type3TitleChipSnippetData(
                                    bgColor = "#00000",
                                    title = TextData(
                                        text = "Cheapest Fares From",
                                        color = "#000000",
                                        font = FontData(16, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)

                                    ),
                                    chip = ChipData(
                                        text = TextData(
                                            text = "New Delhi",
                                            color = "#666666",
                                            font = FontData(14, "regular"),
                                            padding = PaddingData(4, 0, 12, 12)
                                        )
                                    ),
                                    clickAction = ClickAction(
                                        type = "navigate",
                                        destination = "flight_details",
                                        params = mapOf(
                                            "destination" to "bathinda",
                                            "price" to "1680"
                                        )
                                    ),
                                    padding = PaddingData(0, 0, 0, 0),
                                ),
                            )
                        )
                    ),
                    SnippetContainer(
                        layoutConfig = LayoutConfig(
                            snippetType = "spacer_snippet",
                            layoutType = "grid",
                            sectionCount = 1,
                            gridConfig = GridConfig(columns = 1, spacing = 12),
                        ),
                        data = SnippetData(
                            items = listOf(
                                SpacerSnippetData(
                                    height = 16,
                                )
                            )
                        )
                    ),
                    SnippetContainer(
                        layoutConfig = LayoutConfig(
                            snippetType = "image_title_subtitle_type_2",
                            layoutType = "grid",
                            sectionCount = 1,
                            gridConfig = GridConfig(columns = 3, spacing = 12),
                        ),
                        data = SnippetData(
                            items = listOf(
                                Type2SnippetData(
                                    bgColor = "#FFFFFF",
                                    title = TextData(
                                        text = "Bathinda",
                                        color = "#000000",
                                        font = FontData(16, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)

                                    ),
                                    subtitle = TextData(
                                        text = "Thu, 25 Sep",
                                        color = "#666666",
                                        font = FontData(14, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle2 = TextData(
                                        text = "₹1,680",
                                        color = "#000000",
                                        font = FontData(16, "bold"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    image = ImageData(
                                        url = "https://cdn.thecodingshef.in/uploads/265994e64199f8c17892a85fe9e1c80e.png",
                                        contentDescription = "bhatinda"
                                    ),
                                    cornerRadius = 16,
                                    clickAction = ClickAction(
                                        type = "navigate",
                                        destination = "flight_details",
                                        params = mapOf(
                                            "destination" to "bathinda",
                                            "price" to "1680"
                                        )
                                    ),
                                    padding = PaddingData(0, 16, 0, 0),
                                    id = "1"
                                ),
                                Type2SnippetData(
                                    bgColor = "#FFFFFF",
                                    title = TextData(
                                        text = "Hisar",
                                        color = "#000000",
                                        font = FontData(16, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle = TextData(
                                        text = "Sun, 21 Sep",
                                        color = "#666666",
                                        font = FontData(14, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle2 = TextData(
                                        text = "₹1,949",
                                        color = "#000000",
                                        font = FontData(16, "bold"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    image = ImageData(
                                        url = "https://cdn.thecodingshef.in/uploads/3062e1c976e1b29b88dd4f3fe4d9d9ce.png",
                                        contentDescription = "hisar"
                                    ),
                                    cornerRadius = 16,
                                    clickAction = ClickAction(
                                        type = "navigate",
                                        destination = "flight_details",
                                        params = mapOf(
                                            "destination" to "bathinda",
                                            "price" to "1680"
                                        )
                                    ),
                                    padding = PaddingData(0, 16, 0, 0),
                                    id = "1"
                                ),
                                Type2SnippetData(
                                    bgColor = "#FFFFFF",
                                    title = TextData(
                                        text = "Gwalior",
                                        color = "#000000",
                                        font = FontData(16, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle = TextData(
                                        text = "Thu, 02 Oct",
                                        color = "#666666",
                                        font = FontData(14, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle2 = TextData(
                                        text = "₹1,680",
                                        color = "#000000",
                                        font = FontData(16, "bold"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    image = ImageData(
                                        url = "https://cdn.thecodingshef.in/uploads/265994e64199f8c17892a85fe9e1c80e.png",
                                        contentDescription = "bhatinda"
                                    ),
                                    cornerRadius = 16,
                                    clickAction = ClickAction(
                                        type = "navigate",
                                        destination = "flight_details",
                                        params = mapOf(
                                            "destination" to "bathinda",
                                            "price" to "1680"
                                        )
                                    ),
                                    padding = PaddingData(0, 16, 0, 0),
                                    id = "1"
                                ),
                                Type2SnippetData(
                                    bgColor = "#FFFFFF",
                                    title = TextData(
                                        text = "Chandigarh",
                                        color = "#000000",
                                        font = FontData(16, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle = TextData(
                                        text = "Mon, 22 Sep",
                                        color = "#666666",
                                        font = FontData(14, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle2 = TextData(
                                        text = "₹1,680",
                                        color = "#000000",
                                        font = FontData(16, "bold"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    image = ImageData(
                                        url = "https://aws-static.iicdelhi.in/s3fs-public/styles/custom/public/2022-05/Bhatinda-Fort1.jpg?itok=MGiHUrYK",
                                        contentDescription = "bhatinda"
                                    ),
                                    cornerRadius = 16,
                                    clickAction = ClickAction(
                                        type = "navigate",
                                        destination = "flight_details",
                                        params = mapOf(
                                            "destination" to "bathinda",
                                            "price" to "1680"
                                        )
                                    ),
                                    padding = PaddingData(0, 16, 0, 0),
                                    id = "1"
                                ),
                                Type2SnippetData(
                                    bgColor = "#FFFFFF",
                                    title = TextData(
                                        text = "Bathinda",
                                        color = "#000000",
                                        font = FontData(16, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)

                                    ),
                                    subtitle = TextData(
                                        text = "Thu, 25 Sep",
                                        color = "#666666",
                                        font = FontData(14, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle2 = TextData(
                                        text = "₹1,680",
                                        color = "#000000",
                                        font = FontData(16, "bold"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    image = ImageData(
                                        url = "https://cdn.thecodingshef.in/uploads/265994e64199f8c17892a85fe9e1c80e.png",
                                        contentDescription = "bhatinda"
                                    ),
                                    cornerRadius = 16,
                                    clickAction = ClickAction(
                                        type = "navigate",
                                        destination = "flight_details",
                                        params = mapOf(
                                            "destination" to "bathinda",
                                            "price" to "1680"
                                        )
                                    ),
                                    padding = PaddingData(0, 16, 0, 0),
                                    id = "1"
                                ),
                                Type2SnippetData(
                                    bgColor = "#FFFFFF",
                                    title = TextData(
                                        text = "Hisar",
                                        color = "#000000",
                                        font = FontData(16, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle = TextData(
                                        text = "Sun, 21 Sep",
                                        color = "#666666",
                                        font = FontData(14, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle2 = TextData(
                                        text = "₹1,949",
                                        color = "#000000",
                                        font = FontData(16, "bold"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    image = ImageData(
                                        url = "https://cdn.thecodingshef.in/uploads/3062e1c976e1b29b88dd4f3fe4d9d9ce.png",
                                        contentDescription = "hisar"
                                    ),
                                    cornerRadius = 16,
                                    clickAction = ClickAction(
                                        type = "navigate",
                                        destination = "flight_details",
                                        params = mapOf(
                                            "destination" to "bathinda",
                                            "price" to "1680"
                                        )
                                    ),
                                    padding = PaddingData(0, 16, 0, 0),
                                    id = "1"
                                ),
                                Type2SnippetData(
                                    bgColor = "#FFFFFF",
                                    title = TextData(
                                        text = "Gwalior",
                                        color = "#000000",
                                        font = FontData(16, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle = TextData(
                                        text = "Thu, 02 Oct",
                                        color = "#666666",
                                        font = FontData(14, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle2 = TextData(
                                        text = "₹1,680",
                                        color = "#000000",
                                        font = FontData(16, "bold"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    image = ImageData(
                                        url = "https://cdn.thecodingshef.in/uploads/265994e64199f8c17892a85fe9e1c80e.png",
                                        contentDescription = "bhatinda"
                                    ),
                                    cornerRadius = 16,
                                    clickAction = ClickAction(
                                        type = "navigate",
                                        destination = "flight_details",
                                        params = mapOf(
                                            "destination" to "bathinda",
                                            "price" to "1680"
                                        )
                                    ),
                                    padding = PaddingData(0, 16, 0, 0),
                                    id = "1"
                                ),
                                Type2SnippetData(
                                    bgColor = "#FFFFFF",
                                    title = TextData(
                                        text = "Chandigarh",
                                        color = "#000000",
                                        font = FontData(16, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle = TextData(
                                        text = "Mon, 22 Sep",
                                        color = "#666666",
                                        font = FontData(14, "regular"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    subtitle2 = TextData(
                                        text = "₹1,680",
                                        color = "#000000",
                                        font = FontData(16, "bold"),
                                        padding = PaddingData(4, 0, 12, 12)
                                    ),
                                    image = ImageData(
                                        url = "https://aws-static.iicdelhi.in/s3fs-public/styles/custom/public/2022-05/Bhatinda-Fort1.jpg?itok=MGiHUrYK",
                                        contentDescription = "bhatinda"
                                    ),
                                    cornerRadius = 16,
                                    clickAction = ClickAction(
                                        type = "navigate",
                                        destination = "flight_details",
                                        params = mapOf(
                                            "destination" to "bathinda",
                                            "price" to "1680"
                                        )
                                    ),
                                    padding = PaddingData(0, 16, 0, 0),
                                    id = "1"
                                ),

                                )
                        )
                    ),
                    SnippetContainer(
                        layoutConfig = LayoutConfig(
                            snippetType = "image_title_subtitle_type_1",
                            layoutType = "grid",
                            sectionCount = 1,
                            gridConfig = GridConfig(columns = 2, spacing = 12),
                        ),
                        data = SnippetData(
                            items = listOf(
                                Type1SnippetData(
                                    bgColor = "#FFFFFF",
                                    title = TextData(
                                        text = "Bathindaaa",
                                        color = "#000000",
                                        font = FontData(18, "bold")
                                    ),
                                    subtitle = TextData(
                                        text = "Thu, 25 Sep",
                                        color = "#666666",
                                        font = FontData(14, "regular")
                                    ),
                                    padding = PaddingData(16, 16, 16, 16)
                                ),
                                Type1SnippetData(
                                    bgColor = "#FFFFFF",
                                    title = TextData(
                                        text = "Bathinda",
                                        color = "#000000",
                                        font = FontData(18, "bold")
                                    ),
                                    subtitle = TextData(
                                        text = "Thu, 25 Sep",
                                        color = "#666666",
                                        font = FontData(14, "regular")
                                    ),
                                    padding = PaddingData(16, 16, 16, 16)
                                ),
                            )
                        )
                    ),
                )
            )
        )
    }
}

@Serializable
data class Status(
    val code: Int,
    val message: String
)
