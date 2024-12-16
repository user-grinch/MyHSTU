package com.enan.myhstu.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enan.myhstu.NavHandler
import com.enan.myhstu.data.CardItem
import com.enan.myhstu.getTextColor

@Composable
fun CardLayout(modifier: Modifier = Modifier, item: CardItem) {
    val cardWidthFraction = 0.50f
    val cardHeight = 110.dp
    val cardCornerRadius = 10.dp
    val cardElevation = 2.dp
    val imageSize = 40.dp
    val spacerHeight = 5.dp
    val contentPadding = 8.dp

    Card(
        modifier = modifier
            .fillMaxWidth(cardWidthFraction)
            .height(cardHeight),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
        elevation = CardDefaults.elevatedCardElevation(cardElevation),
        shape = RoundedCornerShape(cardCornerRadius),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(imageSize),
                painter = painterResource(id = item.icon),
                contentDescription = "${item.title} Image"
            )
            Spacer(modifier = Modifier.height(spacerHeight))
            Text(
                text = item.title,
                textAlign = TextAlign.Center,
                color = getTextColor(),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    NavHandler()
}
