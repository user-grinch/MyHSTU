package com.enan.myhstu

import androidx.lifecycle.ViewModel
import com.enan.myhstu.data.TabBarItem
import com.enan.myhstu.data.TabBarItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UiViewModel : ViewModel() {
    private val _selectedTab = MutableStateFlow(TabBarItems.personel)
    val selectedTab: StateFlow<TabBarItem> = _selectedTab.asStateFlow()

    fun setSelectedTab(tab: TabBarItem) {
        _selectedTab.update {
            tab
        }
    }

}