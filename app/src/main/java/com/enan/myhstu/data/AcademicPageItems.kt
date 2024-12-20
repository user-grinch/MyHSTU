package com.enan.myhstu.data

import com.enan.myhstu.R

val academicItems = listOf (
    CardItem("Student Portal", R.drawable.student_portal) { viewModel, navController ->
        viewModel.setWebView(webViewList.studentPortal, navController)
    },
    CardItem("Library", R.drawable.library) { viewModel, navController ->
        viewModel.setWebView(webViewList.library, navController)
    },
    CardItem("Academic routine", R.drawable.routine) { viewModel, navController ->
        viewModel.setWebView(webViewList.routine, navController)
    },
    CardItem("Exam Result", R.drawable.result) { viewModel, navController ->
        viewModel.setWebView(webViewList.examResult, navController)
    },
    CardItem("International Students", R.drawable.international) { viewModel, navController ->
        viewModel.setWebView(webViewList.internationalStudents, navController)
    },
    CardItem("Calender", R.drawable.calender) { viewModel, navController ->
        viewModel.setWebView(webViewList.calender, navController)
    },
)

val miscItems = listOf (
    CardItem("Academic Council", R.drawable.book) { viewModel, navController ->
        viewModel.setWebView(webViewList.academicCouncil, navController)
    },
    CardItem("IT Cell", R.drawable.it_cell) { viewModel, navController ->
        navController.navigate(NavBarData.directory.title)
        if (viewModel.searchInfo.value.selectedFaculty != OFFICE_FACULTY_ID) {
            viewModel.setFacultySelection(OFFICE_FACULTY_ID)
        }
        if (viewModel.searchInfo.value.selectedDepartment != ITCELL_DEPARTMENT_ID) {
            viewModel.setDepartmentSelection(ITCELL_DEPARTMENT_ID)
        }
    },
    CardItem("Advisory & Counciling", R.drawable.advisory) { viewModel, navController ->
        navController.navigate(NavBarData.directory.title)
        if (viewModel.searchInfo.value.selectedFaculty != ADVISORY_FACULTY_ID) {
            viewModel.setFacultySelection(ADVISORY_FACULTY_ID)
        }
    },
    CardItem("Medical Center", R.drawable.medical) { viewModel, navController ->
        navController.navigate(NavBarData.directory.title)
        if (viewModel.searchInfo.value.selectedFaculty != OFFICE_FACULTY_ID) {
            viewModel.setFacultySelection(OFFICE_FACULTY_ID)
        }
        if (viewModel.searchInfo.value.selectedDepartment != MEDICAL_DEPARTMENT_FACULTY_ID) {
            viewModel.setDepartmentSelection(MEDICAL_DEPARTMENT_FACULTY_ID)
        }
    },
)