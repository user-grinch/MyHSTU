package com.enan.myhstu.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarItem(
    val title: String = "",
    val selectedIcon: ImageVector = Icons.Filled.Info,
    val unselectedIcon: ImageVector = Icons.Outlined.Info,
)

object NavBarData {
    val home = NavBarItem(title = "Home", selectedIcon = Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home)
    val directory = NavBarItem(title = "Directory", selectedIcon = Icons.Filled.Person, unselectedIcon = Icons.Outlined.Person)
    val academics = NavBarItem(title = "Academics", selectedIcon = Icons.Filled.DateRange, unselectedIcon = Icons.Outlined.DateRange)
    val settings = NavBarItem(title = "Settings", selectedIcon = Icons.Filled.Settings, unselectedIcon = Icons.Outlined.Settings)
    val webview = NavBarItem(title = "WebView")
    val overview = NavBarItem(title = "Overview")
    val vcview = NavBarItem(title = "Chancellor & Vice Chancellors")
    val cgpaCalculatoor = NavBarItem(title = "CGPA Calculator")
}

val tabBarItemsList = listOf (
    NavBarData.home,
    NavBarData.directory,
    NavBarData.academics,
    NavBarData.settings,
)