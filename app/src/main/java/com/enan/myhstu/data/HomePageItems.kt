package com.enan.myhstu.data

import androidx.annotation.DrawableRes
import com.enan.myhstu.R
import kotlinx.coroutines.flow.flatMap

val homePageItems = listOf (
    CardItem("Chancellor & Vice Chancellors", R.drawable.chancellor) { viewModel, navController ->
        navController.navigate(NavBarData.vcview.title)
    },
    CardItem("Proctor Office", R.drawable.proctor) { viewModel, navController ->
        navController.navigate(NavBarData.directory.title)
        if (viewModel.searchInfo.value.selectedFaculty != PROCTOR_FACULTY_ID) {
            viewModel.setFacultySelection(PROCTOR_FACULTY_ID)
        }
    },
    CardItem("Notice Board", R.drawable.notice) { viewModel, navController ->
        viewModel.setWebView(webViewList.noticeBoard, navController)
    },
    CardItem("News & Events", R.drawable.news) { viewModel, navController ->
        viewModel.setWebView(webViewList.newsEvent, navController)
    },
    CardItem("Bus Schedule", R.drawable.bus) { viewModel, navController ->
        viewModel.setWebView(webViewList.transport, navController)
    },
    CardItem("Halls", R.drawable.dormitory) { viewModel, navController ->
        navController.navigate(NavBarData.directory.title)
        if (viewModel.searchInfo.value.selectedFaculty != HALL_FACULTY_ID) {
            viewModel.setFacultySelection(HALL_FACULTY_ID)
        }
    },
)