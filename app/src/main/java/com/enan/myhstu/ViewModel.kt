package com.enan.myhstu

import androidx.lifecycle.ViewModel
import com.enan.myhstu.data.SearchInfo
import com.enan.myhstu.data.NavBarItem
import com.enan.myhstu.data.NavBarItems
import com.enan.myhstu.data.ProfileData
import com.enan.myhstu.data.personnelList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UiViewModel : ViewModel() {
    private val _selectedTab = MutableStateFlow(NavBarItems.settings)
    val selectedTab: StateFlow<NavBarItem> = _selectedTab.asStateFlow()

    private val _searchInfo = MutableStateFlow(SearchInfo())
    val searchInfo: StateFlow<SearchInfo> = _searchInfo.asStateFlow()

    fun setSelectedTab(tab: NavBarItem) {
        _selectedTab.update { tab }
    }

    fun setSearchInfo(info: SearchInfo) {
        _searchInfo.update { info }
    }

    fun toggleCategorySelection(category: String) {
        _searchInfo.update { currentInfo ->
            currentInfo.copy(
                selectedCategories = if (currentInfo.selectedCategories.contains(category)) {
                    currentInfo.selectedCategories - category
                } else {
                    currentInfo.selectedCategories + category
                }
            )
        }
    }

    fun getFilterList(): List<String> {
        return personnelList.flatMap { it.roles }.distinct()
    }

    fun getFilteredTeacherList(): List<ProfileData> {
        val query = _searchInfo.value.query.lowercase()
        val categories = _searchInfo.value.selectedCategories

        return personnelList.filter { teacher ->
            val matchesQuery = teacher.name.lowercase().contains(query)
            val matchesCategory = categories.isEmpty() || categories.any { category ->
                teacher.roles.contains(category)
            }
            matchesQuery && matchesCategory
        }
    }
}
