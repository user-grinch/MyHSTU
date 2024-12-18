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
import com.enan.myhstu.data.NavBarData
import com.enan.myhstu.ui.NavigationLayout
import com.enan.myhstu.ui.screen.HomeScreenLayout
import com.enan.myhstu.ui.HeaderLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enan.myhstu.data.UiViewModel
import com.enan.myhstu.ui.screen.AcademicScreenLayout
import com.enan.myhstu.ui.screen.DirectoryScreenLayout
import com.enan.myhstu.ui.screen.SettingScreenLayout
import com.enan.myhstu.ui.screen.WebViewScreenLayout

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
    CoreTheme {
        val webViewInfo by viewModel.webViewInfo.collectAsState()
        Scaffold(
            topBar = { if (!webViewInfo.show) HeaderLayout(viewModel = viewModel, navController = navController) },
            bottomBar = {
                if (!webViewInfo.show) NavigationLayout(viewModel = viewModel, navController = navController)
            }
        ) { innerPadding ->
            if (webViewInfo.show) {
                WebViewScreenLayout(
                    modifier = Modifier.padding(innerPadding),
                    viewModel = viewModel,
                    navController = navController,
                    title =  webViewInfo.title,
                )
            } else {
                NavHost(navController = navController, startDestination = NavBarData.home.title) {
                    composable(NavBarData.home.title) {
                        HomeScreenLayout(
                            modifier = Modifier.padding(innerPadding),
                            viewModel = viewModel
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
                            viewModel = viewModel
                        )
                    }
                    composable(NavBarData.settings.title) {
                        SettingScreenLayout(
                            modifier = Modifier.padding(innerPadding),
                            viewModel = viewModel
                        )
                    }
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