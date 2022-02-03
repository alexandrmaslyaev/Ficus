package com.example.ficus.ui.compose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun FicusTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = Typography,
        content = content
    )
}

object FicusTheme {
    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography
}