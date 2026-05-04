package com.spirovski.kentapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tab
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spirovski.kentapp.navigation.Routes
import com.spirovski.kentapp.navigation.navigateToScreen
import kentapp.composeapp.generated.resources.Res
import kentapp.composeapp.generated.resources.fitness_logo
import org.jetbrains.compose.resources.painterResource
import kotlin.math.exp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun WorkoutScrn(showWelcomeSnackbar: Boolean = true) {

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(showWelcomeSnackbar) {
        if (showWelcomeSnackbar) {
            snackbarHostState.showSnackbar("Choose your workout")
        }
    }

    val bottomBarIcons = listOf(
        BottomBarTabs(icon = Icons.Default.Home, onClick = { navigateToScreen(Routes.Home)}),
        BottomBarTabs(icon = Icons.Default.AccountCircle, onClick = {}),
        BottomBarTabs(icon = Icons.Default.Add, onClick = {}),
        BottomBarTabs(icon = Icons.Default.Tab, onClick = {})
    )

    var expanded1 by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }
    var expanded3 by remember { mutableStateOf(false) }

    var expandedTp1 by remember { mutableStateOf(false) }
    var expandedTp2 by remember { mutableStateOf(false) }
    var expandedTp3 by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = { CenterAlignedTopAppBar(title = {
            Image(painterResource(Res.drawable.fitness_logo), contentDescription = "logo",
                modifier = Modifier.width(200.dp).height(100.dp))
        },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
            actions = {

                IconButton(onClick = {

                    navigateToScreen(Routes.Profile)

                }) {

                    Icon(imageVector = Icons.Default.Person,
                        contentDescription = "Profilna",
                        modifier = Modifier.size(32.dp))

                }

            }) },

        bottomBar = {

            Column {
                TopShadow()
                BottomAppBar (containerColor = Color.White,
                    modifier = Modifier.height(60.dp),
                    tonalElevation = 8.dp) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        bottomBarIcons.forEach { tab ->
                            Tab(
                                onClick = tab.onClick, modifier = Modifier.weight(1f),
                                selected = true,
                            ) {
                                Icon(imageVector = tab.icon, contentDescription = null, tint = Color.Red)
                            }
                        }
                    }
                }
            }

        }
    ) {

        Column(modifier = Modifier
            .background(Color(0xFFe7e7e7))
            .padding(it)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)) {

            Card(modifier = Modifier.padding(12.dp),
                elevation = CardDefaults.cardElevation(4.dp)) {

                Column(modifier = Modifier.background(Color.White).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(text = "Workout Types and Personal Goals",
                        modifier = Modifier.padding(10.dp),
                        fontWeight = FontWeight.Bold)

                }

            }

            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)) {

                Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp)) {

                    Column(modifier = Modifier.background(Color.White).fillMaxWidth()) {

                        Row(modifier = Modifier.fillMaxWidth().padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {

                            Text(text = "Bodybuilding")

                            IconButton(onClick = {
                                expanded1 =! expanded1
                            }) {

                                Icon(imageVector = if (expanded1) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Strelkata nagore/nadolu")

                            }

                        }

                        AnimatedVisibility(visible = expanded1) {

                            Text("Description Bodybuilding",
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))

                        }

                    }

                }

                Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp)) {

                    Column(modifier = Modifier.background(Color.White).fillMaxWidth()) {

                        Row(modifier = Modifier.fillMaxWidth().padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {

                            Text(text = "Street Workout")

                            IconButton(onClick = {
                                expanded2 =! expanded2
                            }) {

                                Icon(imageVector = if (expanded2) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Strelkata nagore/nadolu")

                            }

                        }

                        AnimatedVisibility(visible = expanded2) {

                            Text("Description Street Workout",
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))

                        }

                    }

                }

                Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp)) {

                    Column(modifier = Modifier.background(Color.White).fillMaxWidth()) {

                        Row(modifier = Modifier.fillMaxWidth().padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {

                            Text(text = "Meditation")

                            IconButton(onClick = {
                                expanded3 =! expanded3
                            }) {

                                Icon(imageVector = if (expanded3) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Strelkata nagore/nadolu")

                            }

                        }

                        AnimatedVisibility(visible = expanded3) {

                            Text("Description Bodybuilding",
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))

                        }

                    }

                }

            }

            HorizontalDivider(modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp)

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)) {

                Card(modifier = Modifier.weight(1f),
                    elevation = CardDefaults.cardElevation(4.dp)) {

                    Column(modifier = Modifier.background(Color.White).fillMaxWidth()) {

                        Row(modifier = Modifier.fillMaxWidth().padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {

                            Text(text = "Bulk")

                            IconButton(onClick = {
                                expandedTp1 =! expandedTp1
                            }) {

                                Icon(imageVector = if (expandedTp1) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Strelkata nagore/nadolu")

                            }

                        }

                        AnimatedVisibility(visible = expandedTp1) {

                            Text("Description Bodybuilding",
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))

                        }

                    }

                }

                Card(modifier = Modifier.weight(1f),
                    elevation = CardDefaults.cardElevation(4.dp)) {

                    Column(modifier = Modifier.background(Color.White).fillMaxWidth()) {

                        Row(modifier = Modifier.fillMaxWidth().padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {

                            Text(text = "Maintain")

                            IconButton(onClick = {
                                expandedTp2 =! expandedTp2
                            }) {

                                Icon(imageVector = if (expandedTp2) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Strelkata nagore/nadolu")

                            }

                        }

                        AnimatedVisibility(visible = expandedTp2) {

                            Text("Description Bodybuilding",
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))

                        }

                    }

                }

                Card(modifier = Modifier.weight(1f),
                    elevation = CardDefaults.cardElevation(4.dp)) {

                    Column(modifier = Modifier.background(Color.White).fillMaxWidth()) {

                        Row(modifier = Modifier.fillMaxWidth().padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {

                            Text(text = "Cut")

                            IconButton(onClick = {
                                expandedTp3 =! expandedTp3
                            }) {

                                Icon(imageVector = if (expandedTp3) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Strelkata nagore/nadolu")

                            }

                        }

                        AnimatedVisibility(visible = expandedTp3) {

                            Text("Description Bodybuilding",
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))

                        }

                    }

                }



            }

        }

    }

}