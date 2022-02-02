package com.example.ficus.ex

import android.content.Context
import android.content.Intent
import androidx.annotation.StringRes

inline fun <reified T : Any> Context.openActivity(block: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(block))
}

fun Context.txt(@StringRes resId: Int): CharSequence = resources.getText(resId)