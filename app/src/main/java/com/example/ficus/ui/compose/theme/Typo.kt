package com.example.ficus.ui.compose.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ficus.R

private val Gilroy = FontFamily(
    Font(R.font.gilroy),
    Font(R.font.gilroy_medium, FontWeight.Medium),
    Font(R.font.gilroy_semibold, FontWeight.SemiBold)
)

internal val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        lineHeight = 33.sp,
        fontSize = 24.sp,
    ),
    h2 = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        lineHeight = 33.sp,
        fontSize = 24.sp,
    ),
    h3 = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        lineHeight = 14.56.sp,
        fontSize = 12.sp,
    ),
    h4 = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        lineHeight = 15.sp,
        fontSize = 12.sp,
    ),
    body1 = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        lineHeight = 14.sp,
        fontSize = 12.sp,
    ),
    body2 = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        lineHeight = 12.sp,
        fontSize = 10.sp,
    ),
    caption = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        lineHeight = 12.sp,
        fontSize = 10.sp,
    ),
    subtitle1= TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        lineHeight = 10.sp,
        fontSize = 8.sp,
    ),
)