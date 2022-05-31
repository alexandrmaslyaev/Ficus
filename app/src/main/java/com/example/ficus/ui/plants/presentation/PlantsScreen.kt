package com.example.ficus.ui.plants.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ficus.R
import com.example.ficus.base.ColorStateValue
import com.example.ficus.base.randomId
import com.example.ficus.base.toImageValue
import com.example.ficus.base.toTextValueChars
import com.example.ficus.ex.txt
import com.example.ficus.ui.common.textbutton.TextButtonVs
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
            Column {
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

                LazyRow(contentPadding = PaddingValues(horizontal = 8.dp)) {
                    items(items = listOf(
                        MyPlantVs(
                            id = randomId(),
                            payload = null,
                            name = "Crassula".toTextValueChars(),
                            time = "00:00:00".toTextValueChars(),
                            image = R.drawable.img_crassula_1.toImageValue(),
                            button = TextButtonVs(value = "Watering".toTextValueChars(), color = )
                        ),
                        MyPlantVs(
                            id = randomId(),
                            payload = null,
                            name = "Crassula".toTextValueChars(),
                            time = "00:00:00".toTextValueChars(),
                            image = R.drawable.img_crassula_1.toImageValue()
                        ),
                        MyPlantVs(
                            id = randomId(),
                            payload = null,
                            name = "Crassula".toTextValueChars(),
                            time = "00:00:00".toTextValueChars(),
                            image = R.drawable.img_crassula_1.toImageValue()
                        ),
                    )) { plant ->
                        MyPlantCard(plant)
                    }
                }
            }
        }
    }
}