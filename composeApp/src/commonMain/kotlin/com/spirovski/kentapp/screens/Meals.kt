package com.spirovski.kentapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tab
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
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
fun MealsAll() {

    val bottomBarIcons = listOf(
        Icons.Default.Home,
        Icons.Default.AccountCircle,
        Icons.Default.Add,
        Icons.Default.Tab,
    )  // Bottom bar ikoni

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
                        bottomBarIcons.forEach { icon ->
                            Tab(
                                onClick = {}, modifier = Modifier.weight(1f),
                                selected = true,
                            ) {
                                Icon(imageVector = icon, contentDescription = null, tint = Color.Red)
                            }
                        }
                    }
                }
            }

        }

    ) {

        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(it)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally) {

            MealsList()

            Spacer(modifier = Modifier.height(30.dp))

            ButtonMeals("Add Meal", modifier = Modifier.fillMaxWidth().padding(10.dp))
            ButtonMeals("Remove Meal", modifier = Modifier.fillMaxWidth().padding(10.dp))

            //TODO: Google AD

        }

    }

}

@Composable
fun MealsList() {

    val meals = remember {
        mutableStateListOf("Chicken and Rice", "Oats and Banana", "Tuna and Eggs")
    }

    Card(modifier = Modifier.fillMaxWidth().height(350.dp).padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(Color.LightGray),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)) {

        LazyColumn(modifier = Modifier.padding(8.dp)) {

            items(meals.size) { index ->

                Card(onClick = {

                    navigateToScreen(Routes.MealDescript)

                }, modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    shape = RoundedCornerShape(5.dp)) {

                    Text(text = meals[index], modifier = Modifier.padding(12.dp))

                }

            }
        }

    }

}

