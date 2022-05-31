package com.example.ficus.ex

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

inline fun <reified T : Any> Context.openActivity(block: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(block))
}

fun Context.txt(@StringRes resId: Int): CharSequence = resources.getText(resId)
fun Context.str(@StringRes resId: Int, vararg formatArgs: Any?): String =
    resources.getString(resId, *formatArgs)

fun Context.quantityStr(
    @PluralsRes resId: Int,
    quantity: Int,
    vararg formatArgs: Any?
): String =
    resources.getQuantityString(resId, quantity, *formatArgs)

@ColorInt
fun Context.color(@ColorRes resId: Int): Int = ContextCompat.getColor(this, resId)

fun Context.colorSL(@ColorRes resId: Int): ColorStateList? =
    ContextCompat.getColorStateList(this, resId)

fun Context.colorSL(vararg statesToColors: Pair<IntArray, Int>): ColorStateList {
    val (states, colors) = statesToColors.unzip()
    return ColorStateList(states.toTypedArray(), colors.map { color(it) }.toIntArray())
}
