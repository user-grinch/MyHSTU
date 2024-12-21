package com.enan.myhstu.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enan.myhstu.NavHandler
import com.enan.myhstu.data.NavBarData
import com.enan.myhstu.data.NavBarItem
import com.enan.myhstu.data.UiViewModel
import com.enan.myhstu.data.VCItem
import com.enan.myhstu.data.VC_TEACHER_ID
import com.enan.myhstu.data.presidentItem
import com.enan.myhstu.data.vcItems
import com.enan.myhstu.database.AppDatabase
import com.enan.myhstu.entity.TeacherDE
import com.enan.myhstu.ui.ProfileCard
import kotlinx.coroutines.flow.update

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun VCScreenLayout(
    modifier: Modifier = Modifier,
    viewModel: UiViewModel
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
        ProfileCard(teacher = viewModel.vcProfile.value, viewModel = viewModel)
        ProfileCard(teacher = viewModel.provcProfile.value, viewModel = viewModel)

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
    var fullscrenMode by remember { mutableStateOf(false) }
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
                        .clickable { fullscrenMode = true }
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

    if (fullscrenMode) {
        Dialog(onDismissRequest = { fullscrenMode = false }) {
            Image(
                painter = painterResource(id = item.picture),
                contentDescription = "Full Screen Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape)
                    .clickable { fullscrenMode = false }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    val appDB = AppDatabase.getDatabase(LocalContext.current)
    val viewModel = UiViewModel(appDB.teacherDao(), appDB.facultyDao(), appDB.departmentDAO())
    NavHandler(viewModel = viewModel, startDestination = NavBarData.vcview.title)
}
