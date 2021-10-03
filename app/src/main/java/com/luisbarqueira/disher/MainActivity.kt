package com.luisbarqueira.disher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.luisbarqueira.disher.category.CategoryScreen
import com.luisbarqueira.disher.ui.theme.DisherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisherTheme {
                DisherApp()
            }
        }
    }
}

@Composable
fun DisherApp() {
    CategoryScreen()
}


// www.themealdb.com/api/json/v1/1/categories.php


