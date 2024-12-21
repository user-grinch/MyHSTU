package com.enan.myhstu.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.enan.myhstu.CustomFilterChip
import com.enan.myhstu.NavHandler
import com.enan.myhstu.data.NavBarData
import com.enan.myhstu.data.UiViewModel
import com.enan.myhstu.data.webViewList
import com.enan.myhstu.database.AppDatabase
import java.security.Key

val gpGrades = setOf(
    "A+" to 4.0,
    "A" to 3.75,
    "A-" to 3.5,
    "B+" to 3.25,
    "B" to 3.0,
    "B-" to 2.75,
    "C+" to 2.5,
    "C" to 2.25,
    "D" to 2.0,
    "F" to 0.0
)

@Composable
fun CGPAScreenLayout(modifier: Modifier = Modifier,
                        viewModel: UiViewModel,
                        navController: NavController
) {
    var courseCount by remember { mutableStateOf(1) }
    var gradeInputs by remember { mutableStateOf(listOf("")) }
    var creditInputs by remember { mutableStateOf(listOf("")) }
    var result by remember { mutableStateOf("") }
    var mExpanded by remember { mutableStateOf(false) }
    var expandedIndex by remember { mutableStateOf(-1) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 150.dp)
                .align(Alignment.BottomCenter)
        ) {
            items(courseCount) { index ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${index+1}",
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(20.dp)
                    )
                    Column {
                        OutlinedTextField(
                            value = gradeInputs[index],
                            onValueChange = {
                                gradeInputs = gradeInputs.toMutableList().apply { set(index, it) }
                            },
                            modifier = Modifier.fillMaxWidth(0.5f),
                            label = { Text("Grade") },
                            trailingIcon = {
                                Icon(
                                    if (mExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                                    null,
                                    Modifier.clickable {
                                        mExpanded = !mExpanded
                                        expandedIndex = if (expandedIndex == index) -1 else index
                                                       },
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = creditInputs[index],
                        onValueChange = {
                            creditInputs = creditInputs.toMutableList().apply { set(index, it) }
                        },
                        label = {
                            Text(
                                text = "Credits",
                                style = MaterialTheme.typography.displaySmall
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        if (expandedIndex != -1) {
            DropdownMenu(
                expanded = mExpanded,
                onDismissRequest = { mExpanded = false },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                gpGrades.forEach { it ->
                    DropdownMenuItem(onClick = {
                        gradeInputs = gradeInputs.toMutableList()
                            .apply { set(expandedIndex, it.second.toString()) }
                        mExpanded = false
                    },
                        text = {
                            Text(text = it.first)
                        })
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = {
                    courseCount++
                    gradeInputs = gradeInputs + ""
                    creditInputs = creditInputs + ""
                }) {
                    Text(
                        text = "Add Course",
                        style = MaterialTheme.typography.displaySmall
                    )
                }
                Button(
                    onClick = {
                        if (courseCount > 1) {
                            courseCount--
                            gradeInputs = gradeInputs.dropLast(1)
                            creditInputs = creditInputs.dropLast(1)
                        }
                    },
                    enabled = courseCount > 1
                ) {
                    Text(
                        text = "Remove Course",
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                val grades = gradeInputs.mapNotNull { it.toDoubleOrNull() }
                val credits = creditInputs.mapNotNull { it.toDoubleOrNull() }

                if (grades.size == credits.size && grades.isNotEmpty()) {
                    val totalGradePoints = grades.zip(credits).sumOf { it.first * it.second }
                    val totalCredits = credits.sum()
                    result = if (totalCredits > 0) {
                        String.format("%.2f", totalGradePoints / totalCredits)
                    } else {
                        "Invalid input"
                    }
                } else {
                    result = "Invalid input"
                }
            }) {
                Text(
                    text = "Calculate CGPA",
                    style = MaterialTheme.typography.displaySmall
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (result.isNotEmpty()) {
                Text(
                    text = "CGPA: $result",
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    val appDB = AppDatabase.getDatabase(LocalContext.current)
    val viewModel = UiViewModel(appDB.teacherDao(), appDB.facultyDao(), appDB.departmentDAO())
    NavHandler(viewModel = viewModel, startDestination = NavBarData.cgpaCalculatoor.title)
}

