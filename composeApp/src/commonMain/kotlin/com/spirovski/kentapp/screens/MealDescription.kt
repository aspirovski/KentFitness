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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.spirovski.kentapp.components.ButtonMeals
import com.spirovski.kentapp.components.UniTextField
import com.spirovski.kentapp.navigation.Routes
import com.spirovski.kentapp.navigation.navigateToScreen
import kentapp.composeapp.generated.resources.Res
import kentapp.composeapp.generated.resources.fitness_logo
import org.jetbrains.compose.resources.painterResource

//TODO: Koga otvorame postoechki meal, da gi ima vekje polni textfields

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MealDescpt() {

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

        var mealName by remember { mutableStateOf("") }
        var mealRecipe by remember { mutableStateOf("") }
        var mealProtein by remember {mutableStateOf("")}
        var mealCarbs by remember {mutableStateOf("")}
        var mealFat by remember {mutableStateOf("")}

        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(it)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)) {

                TextField(value = mealName,
                    onValueChange = {mealName = it},
                    placeholder = { Text("Meal Name") },
                    minLines = 1,
                    maxLines = 50,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedLabelColor = Color.LightGray, focusedLabelColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent))

                TextField(value = mealRecipe,
                    onValueChange = {mealRecipe = it},
                    placeholder = { Text("Meal Recipe") },
                    minLines = 1,
                    maxLines = 50,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedLabelColor = Color.LightGray, focusedLabelColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent))

                Row(horizontalArrangement = Arrangement.spacedBy(3.dp), modifier = Modifier.padding(horizontal = 16.dp)) {

                    UniTextField(value = mealCarbs,
                        onValueChange = {mealCarbs = it},
                        placeholder = "Carbs",
                        modifier = Modifier.weight(1f))

                    UniTextField(value = mealProtein,
                        onValueChange = {mealProtein = it},
                        placeholder = "Protein",
                        modifier = Modifier.weight(1f))

                    UniTextField(value = mealFat,
                        onValueChange = {mealFat = it},
                        placeholder = "Fat",
                        modifier = Modifier.weight(1f))

                }

                ButtonMeals("Save Meal", modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp))
                //TODO: Da go zachuva i da te vrati na Meals
            }

        }

    }

}

