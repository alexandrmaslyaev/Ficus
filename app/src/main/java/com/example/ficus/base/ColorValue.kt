package com.example.ficus.base

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Parcelable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import com.example.ficus.ex.color
import kotlinx.parcelize.Parcelize

sealed class ColorValue : Parcelable {
    @ColorInt
    abstract fun getColor(context: Context): Int

    @Parcelize
    data class Resource(@ColorRes val value: Int) : ColorValue() {
        override fun getColor(context: Context): Int = context.color(value)
    }

    @Parcelize
    data class Color(@ColorInt val value: Int) : ColorValue() {
        @ColorInt
        override fun getColor(context: Context): Int = value
    }

    @Parcelize
    data class Hex(val value: String) : ColorValue() {
        @ColorInt
        override fun getColor(context: Context): Int = android.graphics.Color.parseColor(value)
    }

    @Parcelize
    object NoColor: ColorValue() {
        @ColorInt
        override fun getColor(context: Context): Int = 0
    }
}

fun ColorValue.toColorSL(context: Context): ColorStateList = getColor(context).toColorSL()
fun @receiver:ColorInt Int.toColorSL() = ColorStateList.valueOf(this)
