package com.example.ficus.ui.common

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ficus.base.ColorStateValue
import com.example.ficus.ui.common.textbutton.TextButtonVs

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    vs: TextButtonVs,
    onClick: () -> Unit,
) {
    val buttonColors =
        ButtonDefaults.buttonColors(
            contentColor = vs.color.getContentColor(),
        )
    Button(
        onClick = onClick,
        modifier = Modifier.then(modifier),
        colors = buttonColors,
        shape = RoundedCornerShape(4.dp),
        elevation = null,
    ) {
        val context = LocalContext.current
        Text(
            text = vs.value.getString(context).uppercase(),
            style = MaterialTheme.typography.button,
            textAlign = TextAlign.Center,
            modifier = Modifier.wrapContentHeight()
        )
    }
}


@Composable
private fun ColorStateValue.getContentColor(): Color =
    when (val color = this) {
        is ColorStateValue.Resource -> colorResource(id = color.value)
        is ColorStateValue.StatesToColors -> colorResource(id = color.values.find {
            it.first.contentEquals(intArrayOf(android.R.attr.state_enabled)) || it.first.contentEquals(
                intArrayOf()
            )
        }?.second ?: TODO())
    }