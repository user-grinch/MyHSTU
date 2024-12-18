package com.enan.myhstu.ui.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enan.myhstu.NavHandler
import com.enan.myhstu.R
import com.enan.myhstu.UiViewModel
import com.enan.myhstu.data.academicPageItems
import com.enan.myhstu.ui.CardLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AcademicScreenLayout(modifier: Modifier = Modifier, viewModel: UiViewModel) {
    val LOGO_SIZE: Int = 200
    val GRID_SPACING: Int = 13

    Column (
        modifier = Modifier.padding(GRID_SPACING.dp * 2)
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .align(Alignment.BottomCenter), // Align to the bottom
                horizontalArrangement = Arrangement.spacedBy(GRID_SPACING.dp),
                verticalArrangement = Arrangement.spacedBy(GRID_SPACING.dp),
            ) {
                items(academicPageItems) { item ->
                    CardLayout(item = item)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    NavHandler()
}

