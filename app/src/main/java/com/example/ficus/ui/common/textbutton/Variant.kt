package com.example.ficus.ui.common.textbutton

import androidx.compose.ui.unit.Dp
import com.example.ficus.base.ColorStateValue

sealed class Variant(
    val bgColor: ColorStateValue,
    val rippleColor: ColorStateValue = bgColor,
    val cornerColor: ColorStateValue = bgColor,
    val textColor: ColorStateValue,
    val progressColor: ColorStateValue = textColor,
) {

    data class Primary(val colorScheme: ColorScheme) : Variant(
        bgColor = ColorStateValue.StatesToColors(
            intArrayOf(-android.R.attr.state_enabled) to R.color.neutral_100,
            intArrayOf() to colorScheme.accentColor
        ),
        rippleColor = colorScheme.accentColorDarkened.toColorStateValueResource(),
        textColor = ColorStateValue.StatesToColors(
            intArrayOf(-android.R.attr.state_enabled) to R.color.neutral_300,
            intArrayOf() to R.color.neutral_constant
        )
    )

    data class Secondary(val colorScheme: ColorScheme) : Variant(
        bgColor = R.color.neutral_100.toColorStateValueResource(),
        rippleColor = R.color.neutral_200.toColorStateValueResource(),
        textColor = ColorStateValue.StatesToColors(
            intArrayOf(-android.R.attr.state_enabled) to R.color.neutral_300,
            intArrayOf() to colorScheme.accentColor
        )
    )

    data class Tertiary(val colorScheme: ColorScheme) : Variant(
        bgColor = R.color.transparent.toColorStateValueResource(),
        rippleColor = R.color.neutral_100.toColorStateValueResource(),
        textColor = ColorStateValue.StatesToColors(
            intArrayOf(-android.R.attr.state_enabled) to R.color.neutral_300,
            intArrayOf() to colorScheme.accentColor
        ),
        horizontalPaddingOffset = -4
    )

    data class Outlined(val colorScheme: ColorScheme) : Variant(
        bgColor = R.color.transparent.toColorStateValueResource(),
        rippleColor = R.color.neutral_100.toColorStateValueResource(),
        cornerColor = R.color.neutral_200.toColorStateValueResource(),
        textColor = ColorStateValue.StatesToColors(
            intArrayOf(-android.R.attr.state_enabled) to R.color.neutral_300,
            intArrayOf() to colorScheme.accentColor
        )
    )
}

