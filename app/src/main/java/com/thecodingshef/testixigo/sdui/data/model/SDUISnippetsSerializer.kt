package com.thecodingshef.testixigo.sdui.data.model

import com.thecodingshef.testixigo.sdui.data.model.snippets.Type1SnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type2SnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type3TitleChipSnippetData
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject

object SnippetContainerSerializer : KSerializer<SnippetContainer> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("SnippetContainer") {
        element("layoutConfig", LayoutConfig.serializer().descriptor)
        element("data", SnippetData.serializer().descriptor)
    }

    override fun deserialize(decoder: Decoder): SnippetContainer {
        require(decoder is JsonDecoder) { "This deserializer can only be used with Json format" }

        val jsonObject = decoder.decodeJsonElement().jsonObject

        val layoutConfig = parseLayoutConfig(decoder, jsonObject)
        val items = parseItems(decoder, layoutConfig, jsonObject)

        val data = SnippetData(items = items)

        return SnippetContainer(layoutConfig, data)
    }

    override fun serialize(encoder: Encoder, value: SnippetContainer) {
        throw SerializationException("Serialization is not supported for SnippetContainer")
    }

    private fun parseLayoutConfig(decoder: JsonDecoder, jsonObject: JsonObject): LayoutConfig {
        val layoutConfigJson = jsonObject["layoutConfig"]
            ?: throw SerializationException("Missing 'layoutConfig' in SnippetContainer")

        return decoder.json.decodeFromJsonElement(LayoutConfig.serializer(), layoutConfigJson)
    }

    private fun parseItems(
        decoder: JsonDecoder,
        layoutConfig: LayoutConfig,
        jsonObject: JsonObject
    ): List<SDUISnippets> {
        val dataJson = jsonObject["data"]?.jsonObject
            ?: throw SerializationException("Missing 'data' in SnippetContainer")

        val itemsJson = dataJson["items"] as? JsonArray
            ?: throw SerializationException("'items' should be a JsonArray")

        return itemsJson.map { itemElement ->
            if (itemElement !is JsonObject) throw SerializationException("Each item must be a JsonObject")

            when (layoutConfig.snippetType) {
                SnippetType.IMAGE_TITLE_SUBTITLE_TYPE_1.type -> decoder.json.decodeFromJsonElement(
                    Type1SnippetData.serializer(), itemElement
                )

                SnippetType.IMAGE_TITLE_SUBTITLE_TYPE_2.type -> decoder.json.decodeFromJsonElement(
                    Type2SnippetData.serializer(), itemElement
                )

                SnippetType.TITLE_CHIP_TYPE_3.type -> {
                    decoder.json.decodeFromJsonElement(
                        Type3TitleChipSnippetData.serializer(), itemElement
                    )
                }

                else -> throw SerializationException("Unknown snippetType '${layoutConfig.snippetType}'")
            }
        }
    }
}







