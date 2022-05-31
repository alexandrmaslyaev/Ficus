package com.example.ficus.base

import android.content.Context
import android.content.res.ColorStateList
import android.os.Parcelable
import androidx.annotation.ColorRes
import com.example.ficus.ex.colorSL
import kotlinx.parcelize.Parcelize

sealed class ColorStateValue : Parcelable {
    abstract fun getColorSL(context: Context): ColorStateList?

    @Parcelize
    data class Resource(@ColorRes val value: Int) : ColorStateValue() {
        override fun getColorSL(context: Context) = context.colorSL(value)
    }

    @Parcelize
    class StatesToColors(vararg val values: Pair<IntArray, Int>) : ColorStateValue() {
        override fun getColorSL(context: Context) = context.colorSL(*values)
    }
}
