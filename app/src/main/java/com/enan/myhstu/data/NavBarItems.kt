package com.enan.myhstu.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarItem(
    val id: Int,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

object NavBarItems {
    val home = NavBarItem(id = 0, title = "Home", selectedIcon = Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home)
    val directory = NavBarItem(id = 1, title = "Directory", selectedIcon = Icons.Filled.Person, unselectedIcon = Icons.Outlined.Person)
    val academics = NavBarItem(id = 3, title = "Academics", selectedIcon = Icons.Filled.DateRange, unselectedIcon = Icons.Outlined.DateRange)
}

val tabBarItemsList = listOf (
    NavBarItems.home,
    NavBarItems.directory,
    NavBarItems.academics,
)