package com.enan.myhstu.ui.screen

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.enan.myhstu.data.UiViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreenLayout(
    modifier: Modifier = Modifier,
    viewModel: UiViewModel = viewModel(),
    title: String,
    navController: NavController,
) {
    val webViewInfo by viewModel.webViewInfo.collectAsState()
    val context = LocalContext.current
    val webView = remember { WebView(context) }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Text(
                    text = "$title     MyHSTU",
                    style = MaterialTheme.typography.displayMedium
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        if (webView.canGoBack()) {
                            webView.goBack()
                        } else {
                            viewModel.closeWebView();
                        }
                    }
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            actions = {
                IconButton(onClick = { webView.loadUrl(webViewInfo.url) }) {
                    Icon(Icons.Default.Home, contentDescription = "Home")
                }
                IconButton(onClick = { webView.reload() }) {
                    Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                }
                IconButton(onClick = { viewModel.closeWebView(); }) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
            }
        )

        // WebView content
        AndroidView(
            factory = {
                webView.apply {
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = true
                    loadUrl(webViewInfo.url)
                }
            },
            update = {
                it.loadUrl(webViewInfo.url)
            },
            modifier = Modifier.fillMaxSize()
        )
    }

    // Handle system back button gesture for navigation
    BackHandler {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            viewModel.closeWebView();
        }
    }
}
