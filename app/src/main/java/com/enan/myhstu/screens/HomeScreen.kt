package com.enan.myhstu.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enan.myhstu.NavHandler
import com.enan.myhstu.R
import com.enan.myhstu.data.homePageItems

@Composable
fun HomeScreenLayout(modifier: Modifier = Modifier) {
    val LOGO_SIZE: Int = 200
    val GRID_SPACING: Int = 13

    Column (
        modifier = Modifier.padding(GRID_SPACING.dp * 2)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "HSTU Logo",
                modifier = modifier.size(LOGO_SIZE.dp, LOGO_SIZE.dp)
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(GRID_SPACING.dp),
            verticalArrangement = Arrangement.spacedBy(GRID_SPACING.dp)
        ) {
            items(homePageItems) { item ->
                CardLayout(item = item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    NavHandler()
}

