package com.example.ficus.ui.common.textbutton

import com.example.ficus.base.ColorStateValue
import com.example.ficus.base.ColorValue
import com.example.ficus.base.TextValue
import com.example.ficus.ui.vs.ViewState

data class TextButtonVs(
    override val payload: Any? = null,
    val value: TextValue,
    val color: ColorStateValue
) : ViewState
