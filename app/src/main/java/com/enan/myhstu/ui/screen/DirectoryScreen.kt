package com.enan.myhstu.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enan.myhstu.NavHandler
import com.enan.myhstu.dao.DepartmentShortNameWithId
import com.enan.myhstu.data.UiViewModel
import com.enan.myhstu.data.SearchData
import com.enan.myhstu.ui.ProfileCard
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DirectoryScreenLayout(viewModel: UiViewModel, modifier: Modifier = Modifier) {
    val searchInfo by viewModel.searchInfo.collectAsState()
    val selectedCategories = searchInfo.selectedCategories
    val departmentList by viewModel.departmentList.collectAsState()
    val teacherList by viewModel.teacherList.collectAsState()

    val filteredTeacherList = remember(departmentList, teacherList, searchInfo.query, selectedCategories) {
        derivedStateOf {
            teacherList.filter {
                val isQueryEmpty = searchInfo.query.isEmpty()
                val isCatEmpty = selectedCategories.isEmpty()
                var rtnVal = true

                if (!isCatEmpty) {
                    rtnVal = (it.departmentID ?: "0").toInt() in selectedCategories
                }

                if (!isQueryEmpty) {
                    rtnVal = rtnVal && (searchInfo.query.toLowerCase() in (it.name ?: "").toLowerCase())
                }
                rtnVal
            }
        }
    }.value

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            // SearchBox
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(45.dp)
                    )
            ) {
                TextField(
                    value = searchInfo.query,
                    onValueChange = { viewModel.setSearchInfo(SearchData(searchInfo.show, it)) },
                    placeholder = {
                        Text(
                            text = "Search...",
                            style = MaterialTheme.typography.displaySmall
                        )},
                    singleLine = true,
                    shape = RoundedCornerShape(45.dp),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "Search Icon"
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
            }

            // Role Chips
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                departmentList.forEach { category ->
                    FilterChip(
                        selected = selectedCategories.contains(category.id),
                        onClick = { viewModel.toggleCategorySelection(category.id) },
                        label = { Text(category.shortName) },
                        border = null,
                        leadingIcon = if (selectedCategories.contains(category.id)) {
                            { Icon(Icons.Filled.Check, contentDescription = "Selected") }
                        } else null,
                        colors = FilterChipDefaults.filterChipColors(
                            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                        ),
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                    )
                }
            }

            // Personnel Lists
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(2.dp),
            ) {
                if (filteredTeacherList.isEmpty()) {
                    item {
                        Text(
                            text = "No results found",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                } else {
                    items(filteredTeacherList) { teacher ->
                        ProfileCard(teacher, viewModel)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavHandler()
}