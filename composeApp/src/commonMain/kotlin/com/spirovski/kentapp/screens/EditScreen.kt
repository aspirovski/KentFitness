package com.spirovski.kentapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Tab
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spirovski.kentapp.components.KentBottomAppBar
import com.spirovski.kentapp.components.KentTopAppBar
import com.spirovski.kentapp.navigation.Routes
import com.spirovski.kentapp.navigation.navigateToScreen
import kentapp.composeapp.generated.resources.Res
import kentapp.composeapp.generated.resources.fitness_logo

@Composable
@Preview
fun EditScreen() {

    val bottomBarIcons = listOf(
        BottomBarTabs(icon = Icons.Default.Home, onClick = { navigateToScreen(Routes.Home)}),
        BottomBarTabs(icon = Icons.Default.AccountCircle, onClick = {}),
        BottomBarTabs(icon = Icons.Default.Add, onClick = {}),
        BottomBarTabs(icon = Icons.Default.Tab, onClick = {})
    )

    Scaffold(
        topBar = { KentTopAppBar(logo = Res.drawable.fitness_logo) },
        bottomBar = { KentBottomAppBar() }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            PersonalInfo()
            PersonalParameters()

        }

    }

}

@Composable
fun PersonalInfo() {

    Card(modifier = Modifier.padding(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)) {

        Column(
            modifier = Modifier.background(Color.White).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


        }

    }

}

@Composable
fun PersonalParameters() {

    Card(
        modifier = Modifier.padding(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column(
            modifier = Modifier.background(Color.White).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


        }

    }

}