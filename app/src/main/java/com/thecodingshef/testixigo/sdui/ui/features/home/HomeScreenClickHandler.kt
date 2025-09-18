package com.thecodingshef.testixigo.sdui.ui.features.home

import androidx.navigation.NavHostController
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type1SnippetData
import com.thecodingshef.testixigo.sdui.data.model.snippets.Type2SnippetData
import com.thecodingshef.testixigo.sdui.ui.components.snippets.SnippetClickHandler
import com.thecodingshef.testixigo.sdui.utils.handlers.handleClickAction

class HomeScreenClickHandler(val navController: NavHostController) : SnippetClickHandler {
    override fun onType1SnippetClick(item: Type1SnippetData) {
        handleClickAction(navController, item.clickAction)
    }

    override fun onType1TitleClick(item: Type1SnippetData) {

    }

    override fun onType1SubtitleClick(item: Type1SnippetData) {
    }

    override fun onType2ImageClick(item: Type2SnippetData) {

    }

    override fun onType2SubtitleClick(item: Type2SnippetData) {

    }

    override fun onType3ChipClick() {

    }

}
