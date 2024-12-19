package com.enan.myhstu.data

import androidx.annotation.DrawableRes
import com.enan.myhstu.R

val homePageItems = listOf (
    CardItem("Chancellor & Vice Chancellors", R.drawable.chancellor, { viewModel, navController ->
        navController.navigate(NavBarData.vcview.title)
    }),
    CardItem("International Students", R.drawable.international, { viewModel, navController ->
        viewModel.setWebView(webViewList.internationalStudents, navController)
    }),
    CardItem("Notice Board", R.drawable.notice) { viewModel, navController ->
        viewModel.setWebView(webViewList.noticeBoard, navController)
    },
    CardItem("News & Events", R.drawable.news) { viewModel, navController ->
        viewModel.setWebView(webViewList.newsEvent, navController)
    },
    CardItem("Bus Schedule", R.drawable.bus) { viewModel, navController ->
        viewModel.setWebView(webViewList.transport, navController)
    },
    CardItem("Calender", R.drawable.calender) { viewModel, navController ->
        viewModel.setWebView(webViewList.calender, navController)
    },
)