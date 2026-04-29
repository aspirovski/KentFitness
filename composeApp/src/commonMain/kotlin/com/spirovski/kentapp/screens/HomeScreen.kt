package com.spirovski.kentapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tab
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.spirovski.kentapp.components.ButtonMeals
import com.spirovski.kentapp.navigation.Routes
import com.spirovski.kentapp.navigation.navigateToScreen
import kentapp.composeapp.generated.resources.Res
import kentapp.composeapp.generated.resources.fitness_logo
import org.jetbrains.compose.resources.painterResource

data class BottomBarTabs(
    val icon: ImageVector,
    val onClick: () -> Unit = {}
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun HomeScrn() {

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
    ) {innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            CurrentGoalsCard()

            MealsCard()

            WorkoutTypeCard()

        }
    }
}

@Composable
private fun WorkoutTypeCard() {
    Card(
        modifier = Modifier.fillMaxWidth().height(200.dp).padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(Color.LightGray),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {

            val tip = "Bodybuilding"
            val den = "Chest & Triceps"

            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {

                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Workout type: ")
                    }
                    append(tip)
                }, modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center)

                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Workout for the Day: ")
                    }
                    append(den)
                }, modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center)

            }

            val exercises = listOf(
                "Bench Press",
                "Incline DB",
                "Cable Fly",
                "Triceps Pushdown",
                "Skull Crushers"
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(8.dp)
            ) {

                items(exercises.size) {

                    Box(
                        modifier = Modifier.size(80.dp).background(Color(0xFF444444)),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = exercises[it],
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )

                    }

                }

            }

            ButtonMeals(text = "Edit Workout",
                modifier = Modifier.fillMaxWidth())

        }

    }
}

@Composable
private fun MealsCard() {
    Card (
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        colors = CardDefaults.cardColors(Color.LightGray),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)) {

        Column (modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Today's Meals",
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(8.dp))

                //TODO: So Column dodaj ushte edno dugme "Add Meal" za dodavanje na meal vo delcheto

                Button(
                    onClick = {

                        navigateToScreen(Routes.Meals)

                    },
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp)
                ) {

                    Text("All Meals")

                }
            }

            Spacer(modifier = Modifier.height(8.dp))


            val mealsText = listOf("Chicken and Rice", "Oats + Banana")

            LazyColumn(
                modifier = Modifier.fillMaxWidth().height(120.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {

                items(mealsText.size) {

                    Card(
                        onClick = {
                            navigateToScreen(Routes.MealDescript(mealName = mealsText[it]))
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = mealsText[it],
                            modifier = Modifier.padding(12.dp).fillMaxWidth(),
                            textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }
}

@Composable
fun CurrentGoalsCard() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(Color.LightGray),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp)
        ) {

            Text(
                " Current Goal: Cut \n Protein: 160g/160g \n Carbs: 380g/380g \n Fat: 40g/40g",
                modifier = Modifier.weight(1f).padding(vertical = 6.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {}) {

                Text("???")

            }

        }

    }
}

@Composable
fun TopShadow(alpha: Float = 0.1f, height: Dp = 4.dp, modifier : Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black.copy(alpha = alpha),
                    )
                )
            )
    )
}