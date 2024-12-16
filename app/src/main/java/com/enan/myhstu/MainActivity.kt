package com.enan.myhstu

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enan.myhstu.data.TabBarItems
import com.enan.myhstu.screens.BottomBarLayout
import com.enan.myhstu.screens.HomeScreenLayout
import com.enan.myhstu.screens.TopBarLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enan.myhstu.screens.PersonelScreenLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavHandler()
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun NavHandler(viewModel: UiViewModel = viewModel()) {
    val navController = rememberNavController()
    val selectedTab by viewModel.selectedTab.collectAsState()
    CoreTheme {
        Scaffold(
            topBar = { TopBarLayout(viewModel = viewModel) },
            bottomBar = {
                BottomBarLayout(viewModel = viewModel, navController = navController)
            }
        ) { innerPadding ->
            NavHost(navController = navController, startDestination = selectedTab.title) {
                composable(TabBarItems.home.title) {
                    HomeScreenLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                    viewModel.setSelectedTab(TabBarItems.home)
                }
                composable(TabBarItems.personel.title) {
                    PersonelScreenLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                    viewModel.setSelectedTab(TabBarItems.personel)
                }
                composable(TabBarItems.settings.title) {
                    Text(TabBarItems.settings.title)
                    viewModel.setSelectedTab(TabBarItems.settings)
                }
                composable(TabBarItems.academics.title) {
                    viewModel.setSelectedTab(TabBarItems.academics)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavHandler()
}