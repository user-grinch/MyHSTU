package com.enan.myhstu.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.enan.myhstu.data.UiViewModel
import com.enan.myhstu.getTextColor

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderLayout(modifier: Modifier = Modifier, viewModel: UiViewModel, navController: NavController) {
    CenterAlignedTopAppBar(
        title = {
            Box (
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                val currentTab = navController.currentBackStackEntryAsState()?.value?.destination?.route
                Text(
                    text = currentTab?: "MyHSTU",
                    style = MaterialTheme.typography.displayLarge,
                    color = getTextColor()
                )
            }
        },
    )
}