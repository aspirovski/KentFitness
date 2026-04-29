package com.spirovski.kentapp

import androidx.compose.ui.window.ComposeUIViewController
import com.spirovski.kentapp.di.initKoin
import com.spirovski.kentapp.navigation.NavGraph

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) {
    NavGraph()
}