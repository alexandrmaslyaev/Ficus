package com.example.ficus.ui.plants.presentation

import com.example.ficus.base.ImageValue
import com.example.ficus.base.TextValue
import com.example.ficus.ui.common.textbutton.TextButtonVs
import com.example.ficus.ui.vs.ItemVs

class MyPlantVs(
    override val id: String,
    override val payload: Any?,
    val name: TextValue,
    val time: TextValue,
    val image: ImageValue.Resource,
    val button: TextButtonVs,
) : ItemVs