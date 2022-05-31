package com.example.ficus.base

import android.content.Context
import android.content.res.ColorStateList
import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.IntRange
import kotlinx.parcelize.Parcelize

sealed class ImageValue : Parcelable {

    @Parcelize
    data class Resource(
        @DrawableRes val id: Int,
        val tint: ColorValue? = null,
        private val tintStateList: ColorStateValue? = null,
        @IntRange(from = 0, to = 255) val alpha: Int = 255
    ) : ImageValue() {

        fun getTintSL(context: Context): ColorStateList? =
            tint?.toColorSL(context) ?: tintStateList?.getColorSL(context)
    }

    @Parcelize
    data class Url(val url: String?) : ImageValue()

    @Parcelize
    object NoImage: ImageValue()
}

fun @receiver:DrawableRes Int.toImageValue(
    tint: ColorValue? = null,
    alpha: Int = 255
): ImageValue.Resource =
    ImageValue.Resource(id = this, tint = tint, alpha = alpha)

fun @receiver:DrawableRes Int.toImageValue(
    tintStateList: ColorStateValue,
    alpha: Int = 255
): ImageValue.Resource =
    ImageValue.Resource(id = this, tintStateList = tintStateList, alpha = alpha)

fun String?.toImageValue(): ImageValue = ImageValue.Url(this)
