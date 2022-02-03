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
import com.example.ficus.ui.compose.theme.FicusTheme

@Composable
fun PlantsScreen() {
    FicusTheme {
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
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp),
                Item = {
                    Text(
                        text = context.txt(
                            R.string.main_screen_header
                        ).toString(),
                        style = FicusTheme.typography.h2
                    )
                }, textForIndicator = "8"
            )
        }
    }
}