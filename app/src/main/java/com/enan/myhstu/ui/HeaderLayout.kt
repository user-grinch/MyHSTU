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
import com.enan.myhstu.UiViewModel
import com.enan.myhstu.getTextColor

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarLayout(modifier: Modifier = Modifier, viewModel: UiViewModel) {
    CenterAlignedTopAppBar(
        title = {
            Box (
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                val selectedTab by viewModel.selectedTab.collectAsState()
                Text(
                    text = if (selectedTab.id == 0) "MyHSTU" else selectedTab.title,
                    style = MaterialTheme.typography.displayLarge,
                    color = getTextColor()
                )
            }
        },
    )
}