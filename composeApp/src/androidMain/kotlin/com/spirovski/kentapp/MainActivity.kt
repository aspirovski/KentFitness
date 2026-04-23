package com.spirovski.kentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.spirovski.kentapp.navigation.NavGraph
import com.spirovski.kentapp.screens.HomeScrn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            NavGraph()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    NavGraph()
}