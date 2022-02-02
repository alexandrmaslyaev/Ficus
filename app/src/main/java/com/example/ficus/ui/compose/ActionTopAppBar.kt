package com.example.ficus.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ficus.R
import com.example.ficus.ui.plants.CalendarButton

@Composable
fun ActionTopAppBar(
    titleImage: Painter?,
    elevation: Dp = 0.dp,
    onNavigationIconClick: () -> Unit,
    onActionIconClick: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(
            title = {
                if (titleImage != null) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 32.dp),
                        painter = titleImage,
                        contentDescription = null
                    )
                }
            },
            elevation = elevation,
            backgroundColor = Color.Transparent,
            navigationIcon = {
                IconButton(onClick = onNavigationIconClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_menu),
                        tint = colorResource(id = R.color.brander_green),
                        contentDescription = null
                    )
                }
            },
            actions = { CalendarButton(onActionIconClick) }
        )
    }
}
