package com.enan.myhstu

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enan.myhstu.data.NavBarItems
import com.enan.myhstu.ui.BottomBarLayout
import com.enan.myhstu.ui.screen.HomeScreenLayout
import com.enan.myhstu.ui.TopBarLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enan.myhstu.ui.screen.AcademicScreenLayout
import com.enan.myhstu.ui.screen.DirectoryScreenLayout

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
                composable(NavBarItems.home.title) {
                    HomeScreenLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                    viewModel.setSelectedTab(NavBarItems.home)
                }
                composable(NavBarItems.directory.title) {
                    DirectoryScreenLayout(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                    viewModel.setSelectedTab(NavBarItems.directory)
                }
                composable(NavBarItems.academics.title) {
                    AcademicScreenLayout(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                    viewModel.setSelectedTab(NavBarItems.academics)
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