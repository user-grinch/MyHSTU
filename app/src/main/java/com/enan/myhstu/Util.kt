package com.enan.myhstu

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.enan.myhstu.data.NavBarItem

@Composable
fun getTextColor() :Color {
    if (isSystemInDarkTheme())
        return Color.White
    else
        return Color.Black
}

@Composable
fun IsCurrentNav(navController: NavController, navBar: NavBarItem): Boolean {
    val route = navController.currentBackStackEntryAsState().value?.destination?.route
    return route == navBar.title
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomFilterChip(
    label: String,
    onClick: () -> Unit,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier
) {
    FilterChip(
        border = null,
        selected = isSelected,
        onClick = onClick,
        label = { Text(label) },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
        ),
        modifier = modifier.padding(horizontal = 4.dp)
    )
}

