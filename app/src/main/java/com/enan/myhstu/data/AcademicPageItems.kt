package com.enan.myhstu.data

import com.enan.myhstu.R

val academicPageItems = listOf (
    CardItem("Student Portal", R.drawable.student_portal) { viewModel, navController ->
        viewModel.setWebView(webViewList.studentPortal, navController)
    },
    CardItem("Library", R.drawable.library) { viewModel, navController ->
        viewModel.setWebView(webViewList.library, navController)
    },
    CardItem("Routine", R.drawable.routine) { viewModel, navController ->
        viewModel.setWebView(webViewList.routine, navController)
    },
    CardItem("Exam Result", R.drawable.result) { viewModel, navController ->
        viewModel.setWebView(webViewList.examResult, navController)
    },
)