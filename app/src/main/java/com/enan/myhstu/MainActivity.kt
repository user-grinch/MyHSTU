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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enan.myhstu.data.NavBarData
import com.enan.myhstu.ui.NavigationLayout
import com.enan.myhstu.ui.screen.HomeScreenLayout
import com.enan.myhstu.ui.HeaderLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.room.Database
import com.enan.myhstu.data.UiViewModel
import com.enan.myhstu.database.AppDatabase
import com.enan.myhstu.ui.screen.AcademicScreenLayout
import com.enan.myhstu.ui.screen.DirectoryScreenLayout
import com.enan.myhstu.ui.screen.OverviewScreenLayout
import com.enan.myhstu.ui.screen.SettingScreenLayout
import com.enan.myhstu.ui.screen.VCScreenLayout
import com.enan.myhstu.ui.screen.WebViewScreenLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appDB = AppDatabase.getDatabase(LocalContext.current)
            val viewModel = UiViewModel(appDB.teacherDao(), appDB.facultyDao(), appDB.departmentDAO())
            NavHandler(viewModel)
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun NavHandler(viewModel: UiViewModel = viewModel()) {
    val navController = rememberNavController()
    CoreTheme {
        val webViewInfo by viewModel.webViewInfo.collectAsState()
        Scaffold(
            topBar = {
                if (!IsCurrentNav(navController, NavBarData.webview)) {
                    val currentTab = navController.currentBackStackEntryAsState()?.value?.destination?.route
                    HeaderLayout(
                        title = currentTab?: "MyHSTU"
                    )
                }
            },
            bottomBar = {
                NavigationLayout(viewModel = viewModel, navController = navController)
            }
        ) { innerPadding ->
            NavHost(navController = navController, startDestination = NavBarData.academics.title) {
                composable(NavBarData.home.title) {
                    HomeScreenLayout(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel,
                        navController = navController
                    )
                }
                composable(NavBarData.directory.title) {
                    DirectoryScreenLayout(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                }
                composable(NavBarData.academics.title) {
                    AcademicScreenLayout(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel,
                        navController = navController
                    )
                }
                composable(NavBarData.settings.title) {
                    SettingScreenLayout(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel,
                        navController = navController
                    )
                }
                composable(NavBarData.webview.title) {
                    WebViewScreenLayout(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel,
                        navController = navController
                    )
                }
                composable(NavBarData.overview.title) {
                    OverviewScreenLayout(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                }
                composable(NavBarData.vcview.title) {
                    VCScreenLayout(
                        modifier = Modifier.padding(innerPadding),
                    )
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