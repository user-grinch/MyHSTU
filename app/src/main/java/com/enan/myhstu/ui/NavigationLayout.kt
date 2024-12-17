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
import com.enan.myhstu.UiViewModel
import com.enan.myhstu.data.tabBarItemsList

@Composable
fun BottomBarLayout(navController: NavController, viewModel: UiViewModel) {
    val seelctedTab by viewModel.selectedTab.collectAsState()
    var selectedTabIndex by rememberSaveable {
        mutableStateOf(seelctedTab.id)
    }

    NavigationBar {
        tabBarItemsList.forEachIndexed { index, tabBarItem ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    navController.navigate(tabBarItem.title)
                },
                icon = {
                    Icon(
                        imageVector = if (selectedTabIndex == index) {tabBarItem.selectedIcon} else {tabBarItem.unselectedIcon},
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