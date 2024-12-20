package com.enan.myhstu.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.enan.myhstu.NavHandler
import com.enan.myhstu.R
import com.enan.myhstu.data.NavBarData
import com.enan.myhstu.data.UiViewModel
import com.enan.myhstu.data.homePageItems
import com.enan.myhstu.ui.CardLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenLayout(viewModel: UiViewModel, navController: NavController, modifier: Modifier = Modifier) {
    val GRID_SPACING: Int = 13
    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.mipmap.logo_foreground),
            contentDescription = "HSTU Logo",
            modifier = Modifier.size(300.dp, 300.dp),
        )
    }

    Column(
        modifier = modifier
            .padding(GRID_SPACING.dp * 2)
            .fillMaxSize()
    ) {
        // Row for Filter Chips
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 240.dp), // Space for logo
            horizontalArrangement = Arrangement.Center,
        ) {
            FilterChip(
                selected = false,
                onClick = { navController.navigate(NavBarData.overview.title) },
                label = { Text("Overview of HSTU") },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                ),
                border = null,
                modifier = Modifier.padding(4.dp)
            )
        }

        // Spacer takes the remaining space
        Spacer(modifier = modifier.weight(1f))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(GRID_SPACING.dp),
            verticalArrangement = Arrangement.spacedBy(GRID_SPACING.dp)
        ) {
            items(homePageItems) { item ->
                CardLayout(item = item,
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    NavHandler()
}

