package com.enan.myhstu.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.enan.myhstu.R
import com.enan.myhstu.dao.DepartmentShortNameWithId
import com.enan.myhstu.data.CardItem
import com.enan.myhstu.data.UiViewModel
import com.enan.myhstu.entity.TeacherDE
import com.enan.myhstu.getTextColor
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

@Composable
fun CardLayout(modifier: Modifier = Modifier,
               item: CardItem,
               viewModel: UiViewModel,
               navController: NavController) {
    val cardWidthFraction = 0.50f
    val cardHeight = 110.dp
    val cardCornerRadius = 10.dp
    val cardElevation = 0.dp
    val imageSize = 40.dp
    val spacerHeight = 5.dp
    val contentPadding = 8.dp

    Card(
        modifier = modifier
            .fillMaxWidth(cardWidthFraction)
            .height(cardHeight)
            .clickable {
                item.func?.invoke(viewModel, navController)
            },
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

@Composable
fun ProfileCard(teacher: TeacherDE,
                viewModel: UiViewModel
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        val departmentList by viewModel.departmentList.collectAsState()
        val deptName = remember(teacher) {
            derivedStateOf {
                departmentList.filter {
                    it.id == (teacher.departmentID ?: "0").toInt()
                }
            }.value
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                var resourceID =LocalContext.current.resources.getIdentifier(teacher.username,
                    "drawable", LocalContext.current.packageName)
                if (resourceID == 0) {
                    resourceID = R.drawable.male
                }

                Image(
                    painter = painterResource(id = resourceID),
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
                        text = teacher.name ?: "Unknown",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text =  "Dept. of ${deptName[0].shortName}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = teacher.email ?: "Unknown",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Phone: +${teacher.mobile}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Roles
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .horizontalScroll(rememberScrollState()),
//                horizontalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                teacher.roles.forEach { role ->
//                    Box(
//                        modifier = Modifier
//                            .background(
//                                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
//                                shape = RoundedCornerShape(50)
//                            )
//                            .padding(horizontal = 12.dp, vertical = 4.dp)
//                    ) {
//                        Text(
//                            text = role,
//                            style = MaterialTheme.typography.bodySmall, // Matching other font styles
//                            color = MaterialTheme.colorScheme.onSurface
//                        )
//                    }
//                }
//            }

            Spacer(modifier = Modifier.height(8.dp))

            // Buttons
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                val context = LocalContext.current

                TextButton(onClick = {
                    val callIntent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:+${teacher.mobile}")
                    }
                    context.startActivity(callIntent)
                }) {
                    Icon(Icons.Default.Call, contentDescription = "Call", tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Call")
                }

                TextButton(onClick = {
                    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:${teacher.email}")
                    }
                    context.startActivity(emailIntent)
                }) {
                    Icon(Icons.Default.Email, contentDescription = "Mail", tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Mail")
                }

                TextButton(onClick = {
                    val whatsappIntent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse("https://wa.me/+${teacher.mobile}")
                    }
                    context.startActivity(whatsappIntent)
                }) {
                    Icon(Icons.Default.AccountBox, contentDescription = "WhatsApp", tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("WhatsApp")
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun Preview() {
//    ProfileCard(personnelList[0])
//}
