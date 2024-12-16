package com.enan.myhstu

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun getTextColor() :Color {
    if (isSystemInDarkTheme())
        return Color.White
    else
        return Color.Black
}