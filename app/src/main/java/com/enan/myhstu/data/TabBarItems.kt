package com.enan.myhstu.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class TabBarItem(
    val id: Int,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

object TabBarItems {
    val home = TabBarItem(id = 0, title = "Home", selectedIcon = Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home)
    val personel = TabBarItem(id = 1, title = "Personnel", selectedIcon = Icons.Filled.Person, unselectedIcon = Icons.Outlined.Person)
    val settings = TabBarItem(id = 2, title = "Settings", selectedIcon = Icons.Filled.Settings, unselectedIcon = Icons.Outlined.Settings)
    val academics = TabBarItem(id = 3, title = "Academics", selectedIcon = Icons.Filled.DateRange, unselectedIcon = Icons.Outlined.DateRange)
}

val tabBarItemsList = listOf (
    TabBarItems.home,
    TabBarItems.personel,
    TabBarItems.academics,
    TabBarItems.settings,
)