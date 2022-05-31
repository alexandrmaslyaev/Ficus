package com.example.ficus.ui.vs

interface ViewState {
    val payload: Any?
}

interface ItemVs : ViewState {
    override val payload: Any?
    val id: String
}