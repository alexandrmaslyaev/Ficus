package com.example.ficus.ui.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ficus.R
import com.example.ficus.ui.compose.theme.FicusTheme

@Composable
fun Indicator(
    bgColor: Color = colorResource(id = R.color.notification),
    text: String?,
    textColor: Color = colorResource(id = R.color.brander_green)
) {
    Box(Modifier.size(12.dp)) {
        Canvas(
            modifier = Modifier.size(12.dp),
            onDraw = {
                drawCircle(color = bgColor)
            }
        )
        if (text != null) {
            Text(
                modifier = Modifier.fillMaxSize().padding(top = 1.dp),
                text = text,
                color = textColor,
                textAlign = TextAlign.Center,
                style = FicusTheme.typography.subtitle1
            )
        }
    }
}