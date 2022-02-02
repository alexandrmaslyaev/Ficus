package com.example.ficus.ui.plants

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.ficus.R

@Composable
fun CalendarButton(onActionIconClick: () -> Unit) {
    IconButton(onClick = { onActionIconClick() }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_calendar),
            contentDescription = null,
            tint = colorResource(id = R.color.brander_green),
        )
    }
}