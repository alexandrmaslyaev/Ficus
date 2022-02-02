package com.example.ficus.ui.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ItemWithIndicator(
    modifier: Modifier = Modifier,
    Item: @Composable () -> Unit,
    textForIndicator: String
) {
    Row(modifier = modifier) {
        Item()
        Indicator(text = textForIndicator)
    }
}