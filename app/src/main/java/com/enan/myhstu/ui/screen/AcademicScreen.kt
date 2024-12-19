package com.enan.myhstu.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.enan.myhstu.NavHandler
import com.enan.myhstu.data.NavBarData
import com.enan.myhstu.data.UiViewModel
import com.enan.myhstu.data.academicPageItems
import com.enan.myhstu.data.webViewList
import com.enan.myhstu.ui.CardLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AcademicScreenLayout(modifier: Modifier = Modifier,
                         viewModel: UiViewModel,
                         navController: NavController) {
    val LOGO_SIZE: Int = 200
    val GRID_SPACING: Int = 13

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(GRID_SPACING.dp * 2),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row for Filter Chips
        Row {
            FilterChip(
                selected = false,
                onClick = {
                    viewModel.setWebView(webViewList.regentBoard, navController)
                },
                label = { Text("Regent Board") },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                ),
                border = null,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            FilterChip(
                selected = false,
                onClick = {
                          viewModel.setWebView(webViewList.academicCouncil, navController)
                },
                label = { Text("Academic Council") },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                ),
                border = null,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
        Spacer(modifier = Modifier.padding(15.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(GRID_SPACING.dp),
            verticalArrangement = Arrangement.spacedBy(GRID_SPACING.dp),
        ) {
            items(academicPageItems) { item ->
                CardLayout(item = item, viewModel = viewModel, navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    NavHandler()
}

