package com.enan.myhstu.data

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UiViewModel : ViewModel() {
    private val _searchInfo = MutableStateFlow(SearchData())
    val searchInfo: StateFlow<SearchData> = _searchInfo.asStateFlow()

    private val _webViewInfo = MutableStateFlow(WebViewData())
    val webViewInfo: StateFlow<WebViewData> = _webViewInfo.asStateFlow()

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
