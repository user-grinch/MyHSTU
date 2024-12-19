package com.enan.myhstu.data

import android.webkit.WebView
import androidx.compose.runtime.remember
import com.enan.myhstu.R

data class WebViewData (
    val url: String = "",
    val title: String = "",
)

object webViewList {
    val noticeBoard = WebViewData (
        url = "https://hstu.ac.bd/page/all_notice/type/c",
        title = "Notice Board"
    )
    val newsEvent = WebViewData (
        url = "https://hstu.ac.bd/page/news_events",
        title = "News & Event"
    )
    val hstuWebsite = WebViewData (
        url = "https://hstu.ac.bd/",
        title = "HSTU Website"
    )
    val transport = WebViewData (
        url = "https://hstu.ac.bd/page/transport",
        title = "Bus Schedule"
    )
    val calender = WebViewData (
        url = "https://hstu.ac.bd/page/academic_calender",
        title = "Calender"
    )
    val sourceCode = WebViewData (
        url = "https://github.com/user-grinch/MyHSTU",
        title = "GitHub Source"
    )
    val examResult = WebViewData (
        url = "https://hstu.ac.bd/page/exam_result",
        title = "Exam Result"
    )
    val studentPortal = WebViewData (
        url = "https://myinfo.hstu.ac.bd/",
        title = "Student Portal"
    )
    val routine = WebViewData (
        url = "https://hstu.ac.bd/uploads/routine/",
        title = "Routine"
    )
    val library = WebViewData (
        url = "https://library.hstu.ac.bd/",
        title = "Library"
    )
    val regentBoard = WebViewData (
        url = "https://hstu.ac.bd/page/regent_board",
        title = "Regent Board"
    )
    val academicCouncil = WebViewData (
        url = "https://hstu.ac.bd/page/academic_council",
        title = "Academic Council"
    )
    val internationalStudents = WebViewData (
        url = "https://hstu.ac.bd/international_students",
        title = "International Students"
    )
}