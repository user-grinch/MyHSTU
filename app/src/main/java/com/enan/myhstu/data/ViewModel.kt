package com.enan.myhstu.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.enan.myhstu.dao.DepartmentDAO
import com.enan.myhstu.dao.FacultyDAO
import com.enan.myhstu.dao.TeacherDAO
import com.enan.myhstu.entity.DepartmentDE
import com.enan.myhstu.entity.FacultyDE
import com.enan.myhstu.entity.TeacherDE
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class UiViewModel(
    private val teacherDao: TeacherDAO,
    private val facultyDAO: FacultyDAO,
    private val departmentDAO: DepartmentDAO,
) : ViewModel() {
    private val _searchInfo = MutableStateFlow(SearchData())
    val searchInfo: StateFlow<SearchData> = _searchInfo.asStateFlow()

    private val _webViewInfo = MutableStateFlow(WebViewData())
    val webViewInfo: StateFlow<WebViewData> = _webViewInfo.asStateFlow()

    val teacherList: StateFlow<List<TeacherDE>> = teacherDao.getAll()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    val facultyList: StateFlow<List<FacultyDE>> = facultyDAO.getAll()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    val departmentList: StateFlow<List<DepartmentDE>> = departmentDAO.getAll()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories.asStateFlow()

    init {
        viewModelScope.launch {
            departmentDAO.getAllShortNames()
                .collect { list ->
                    _categories.value = list
                }
        }
    }

    fun setWebView(webViewData: WebViewData, navController: NavController) {
        _webViewInfo.update {
            it.copy (
                url = webViewData.url,
                title = webViewData.title,
            )
        }
        navController.navigate(NavBarData.webview.title)
    }

    fun setSearchInfo(info: SearchData) {
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

    fun getFilterList(): Flow<List<String>> {
        return departmentDAO.getAllShortNames()
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
