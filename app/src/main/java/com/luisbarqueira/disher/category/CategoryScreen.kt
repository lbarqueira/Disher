package com.luisbarqueira.disher.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.luisbarqueira.disher.category.model.Category
import com.luisbarqueira.disher.category.viewmodel.CategoryViewModel


@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val listOfCategories by remember {
        viewModel.listOfCategories
    }

    LazyColumn {
        items(listOfCategories) { item ->
            SingleCategoryItem(category = item)
        }
    }

}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun SingleCategoryItem(
    category: Category
) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(80.dp),
                painter = rememberImagePainter(
                    category.strCategoryThumb
                ),
                contentDescription = null
            )
            Text(
                text = category.strCategory,
                fontSize = 24.sp
            )

        }

    }
}

@Preview
@Composable
fun PreviewCategoryScreen() {
    CategoryScreen()
}