package com.enan.myhstu

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.enan.myhstu.data.NavBarItem

@Composable
fun getTextColor() :Color {
    if (isSystemInDarkTheme())
        return Color.White
    else
        return Color.Black
}

@Composable
fun IsCurrentNav(navController: NavController, navBar: NavBarItem): Boolean {
    val route = navController.currentBackStackEntryAsState().value?.destination?.route
    return route == navBar.title
}