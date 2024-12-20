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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.enan.myhstu.CustomFilterChip
import com.enan.myhstu.NavHandler
import com.enan.myhstu.data.NavBarData
import com.enan.myhstu.data.UiViewModel
import com.enan.myhstu.data.academicPageItems
import com.enan.myhstu.data.webViewList
import com.enan.myhstu.database.AppDatabase
import com.enan.myhstu.ui.CardLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AcademicScreenLayout(modifier: Modifier = Modifier,
                         viewModel: UiViewModel,
                         navController: NavController) {
    val GRID_SPACING: Int = 13

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(GRID_SPACING.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row for Filter Chips
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            ) {
            CustomFilterChip(
                label = "Regent Board",
                onClick = {
                    viewModel.setWebView(webViewList.regentBoard, navController)
                }
            )
            CustomFilterChip(
                label = "Academic Council",
                onClick = {
                    viewModel.setWebView(webViewList.academicCouncil, navController)
                }
            )
        }

        Spacer(modifier = Modifier.padding(bottom = GRID_SPACING.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(GRID_SPACING.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = GRID_SPACING.dp)
        ) {
            academicPageItems.chunked(2).forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(GRID_SPACING.dp),
                ) {
                    rowItems.forEach { item ->
                        CardLayout(
                            item = item,
                            viewModel = viewModel,
                            navController = navController,
                            modifier = Modifier
                                .weight(1f, fill = true)
                                .fillMaxWidth()
                        )
                    }
                    if (rowItems.size < 2) {
                        Spacer(modifier = Modifier.weight(1f, fill = true))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    val appDB = AppDatabase.getDatabase(LocalContext.current)
    val viewModel = UiViewModel(appDB.teacherDao(), appDB.facultyDao(), appDB.departmentDAO())
    NavHandler(viewModel = viewModel, startDestination = NavBarData.academics.title)
}

