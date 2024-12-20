package com.enan.myhstu.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.enan.myhstu.dao.DepartmentDAO
import com.enan.myhstu.dao.FacultyDAO
import com.enan.myhstu.dao.TeacherDAO
import com.enan.myhstu.entity.TeacherDE
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

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
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    val facultyList: StateFlow<List<ShortNameWithID>> = facultyDAO.getAllShortNamesWithID()
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    val departmentList: StateFlow<List<ShortNameWithID>> = departmentDAO.getAllShortNamesWithID()
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    @OptIn(ExperimentalCoroutinesApi::class)
    val filteredDepartmentList: StateFlow<List<ShortNameWithID>> =
        _searchInfo.flatMapLatest { searchData ->
            departmentDAO.getAllShortNamesWithIDOfFaculty(searchData.selectedFaculty)
        }.stateIn(viewModelScope, SharingStarted.Eagerly, listOf(
            ShortNameWithID("TESTING DATA", 0)
        ))

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

    fun setFacultySelection(value: Int) {
        _searchInfo.update { currentInfo ->
            currentInfo.copy(
                selectedFaculty = (if (currentInfo.selectedFaculty == value) null else value)
            )
        }
        _searchInfo.value.selectedDepartment?.let {setDepartmentSelection(it)}
    }

    fun setDepartmentSelection(value: Int) {
        _searchInfo.update { currentInfo ->
            currentInfo.copy(
                selectedDepartment = (if (currentInfo.selectedDepartment == value) null else value)
            )
        }
    }
}
