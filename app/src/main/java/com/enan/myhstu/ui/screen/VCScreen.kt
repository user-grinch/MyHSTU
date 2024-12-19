package com.enan.myhstu.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enan.myhstu.NavHandler
import com.enan.myhstu.data.VCItem
import com.enan.myhstu.data.presidentItem
import com.enan.myhstu.data.vcItems
import kotlinx.coroutines.flow.update

@Composable
fun VCScreenLayout(
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier
            .padding(15.dp)
            .verticalScroll(rememberScrollState())
    ){
        Text(
            text = "Present",
            style = MaterialTheme.typography.displayMedium
        )
        VCProfileCard(item = presidentItem)
        VCProfileCard(item = vcItems.last())

        Spacer(modifier = Modifier.padding(top = 40.dp))
        Text(
            text = "Previous",
            style = MaterialTheme.typography.displayMedium
        )
        val previous = vcItems.dropLast(1)

        Column(modifier = Modifier.fillMaxWidth()) {
            previous.forEach { item ->
                VCProfileCard(item = item)
            }
        }
    }
}

@Composable
fun VCProfileCard(item: VCItem) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = item.picture),
                    contentDescription = "Teacher Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = item.role,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = item.timeline,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Previwe() {
    NavHandler()
}
