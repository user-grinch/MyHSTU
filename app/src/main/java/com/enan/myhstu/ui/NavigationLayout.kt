package com.enan.myhstu.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.enan.myhstu.NavHandler
import com.enan.myhstu.data.NavBarData
import com.enan.myhstu.data.UiViewModel
import com.enan.myhstu.data.tabBarItemsList

@Composable
fun NavigationLayout(navController: NavController, viewModel: UiViewModel) {
    val currentRoute = navController.currentBackStackEntryFlow.collectAsState(initial = null).value?.destination?.route ?: NavBarData.home.title
    NavigationBar {
        tabBarItemsList.forEachIndexed { index, tabBarItem ->
            NavigationBarItem(
                selected = currentRoute == tabBarItem.title,
                onClick = {
                    navController.navigate(tabBarItem.title)
                },
                icon = {
                    Icon(
                        imageVector = if (currentRoute == tabBarItem.title) {tabBarItem.selectedIcon} else {tabBarItem.unselectedIcon},
                        contentDescription = tabBarItem.title,
                    )
                },
                label = {Text(tabBarItem.title)})
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    NavHandler()
}