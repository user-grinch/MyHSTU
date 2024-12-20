package com.enan.myhstu.data

data class SearchData (
    val show: Boolean = false,
    val query: String = "",
    val selectedFaculty: Int? = null,
    val selectedDepartment: Int? = null,
)