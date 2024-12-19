package com.enan.myhstu.data

import androidx.annotation.DrawableRes
import androidx.navigation.NavController

data class CardItem (
    val title: String,
    @DrawableRes val icon: Int,
    val func: ((viewModel: UiViewModel, navController: NavController) -> Unit)?
)