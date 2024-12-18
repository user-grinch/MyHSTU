package com.enan.myhstu

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.enan.myhstu.R

val Roboto = FontFamily(
    Font(R.font.roboto_regular),
    Font(R.font.roboto_bold, FontWeight.Bold)
)

val Josefin = FontFamily(
    Font(R.font.josefinsans_regular),
    Font(R.font.josefinsans_bold, FontWeight.Bold)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Josefin,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Josefin,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Josefin,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)
