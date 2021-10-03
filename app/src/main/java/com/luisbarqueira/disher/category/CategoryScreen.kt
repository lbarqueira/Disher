package com.luisbarqueira.disher.category

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun CategoryScreen() {
    val categories: List<String> = getFakeData()
    Column() {
        for (category in categories) {
            Text(text = category)
        }
    }

}


fun getFakeData(): List<String> {
    return listOf(
        "Fish",
        "Vegan",
        "Meat"
    )
}


@Preview
@Composable
fun PreviewCategoryScreen() {
    CategoryScreen()
}