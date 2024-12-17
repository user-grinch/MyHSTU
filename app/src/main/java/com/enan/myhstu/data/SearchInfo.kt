package com.enan.myhstu.data

data class SearchInfo (
    val show: Boolean = false,
    val query: String = "",
    val selectedCategories: Set<String> = setOf(),
)