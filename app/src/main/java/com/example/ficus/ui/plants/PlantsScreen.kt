package com.example.ficus.ui.plants

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ficus.R
import com.example.ficus.ex.txt
import com.example.ficus.ui.compose.ActionTopAppBar
import com.example.ficus.ui.compose.ItemWithIndicator

@Composable
fun PlantsScreen() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            ActionTopAppBar(
                titleImage = painterResource(id = R.drawable.ic_title),
                onNavigationIconClick = {},
                onActionIconClick = {}
            )
        }
    ) {
        ItemWithIndicator(
            modifier = Modifier.padding(horizontal = 16.dp),
            Item = {
                Text(text = context.txt(R.string.main_screen_header).toString())
            }, textForIndicator = "1"
        )
    }
}