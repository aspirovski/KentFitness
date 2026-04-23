package com.spirovski.kentapp.screens

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
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spirovski.kentapp.components.ButtonMeals
import com.spirovski.kentapp.navigation.Routes
import com.spirovski.kentapp.navigation.navigateToScreen
import kentapp.composeapp.generated.resources.Res
import kentapp.composeapp.generated.resources.fitness_logo
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun ProfileScrn() {

    val bottomBarIcons = listOf(
        BottomBarTabs(icon = Icons.Default.Home, onClick = { navigateToScreen(Routes.Home)}),
        BottomBarTabs(icon = Icons.Default.AccountCircle, onClick = {}),
        BottomBarTabs(icon = Icons.Default.Add, onClick = {}),
        BottomBarTabs(icon = Icons.Default.Tab, onClick = {})
    )

    Scaffold(
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
            .fillMaxSize()
            .padding(it)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)) {

            Card(modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                elevation = CardDefaults.cardElevation(4.dp)) {

                Column(modifier = Modifier.background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween) {

                        Column(horizontalAlignment = Alignment.Start) {

                            IconButton(onClick = {

                                navigateToScreen(Routes.Profile)

                            }) {

                                Icon(imageVector = Icons.Default.Person,
                                    contentDescription = "Profilna",
                                    modifier = Modifier.size(32.dp))

                            }

                            Text(text = "Andrej")
                            Text(text = "Spirovski")

                        }

                        Column(modifier = Modifier.padding(vertical = 6.dp)) {

                            Text(text = "Visina")
                            Text(text = "Tezhina")
                            Text(text = "Cut/Bulk/Maintain")
                            Text(text = "Bodybuilding/SW")

                        }

                    }

                    ButtonMeals(text = "Edit Profile", modifier = Modifier.padding(vertical = 4.dp))

                }

            }

            Card(modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                elevation = CardDefaults.cardElevation(4.dp)) {

                Column(modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp)) {

                    ButtonMeals(text = "Notifications",
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .fillMaxWidth())

                    ButtonMeals(text = "FAQ's",
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .fillMaxWidth())

                    ButtonMeals(text = "Terms of Use",
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .fillMaxWidth())

                    ButtonMeals(text = "Help & Support",
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .fillMaxWidth())

                    ButtonMeals(text = "Logout",
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .fillMaxWidth())

                    ButtonMeals(text = "Delete Account",
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .fillMaxWidth())

                }

            }

        }

        //TODO: Razmisli tuka posle seto ova, sho da ima

    }

}