package com.spirovski.kentapp.screens

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
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun HomeScrn() {

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = {Text("Kent Fitness")}) },
        bottomBar = {
            BottomAppBar {
                Row(modifier = Modifier.fillMaxWidth()) {
                    repeat(4) {
                        Tab(
                            onClick = {}, modifier = Modifier.weight(1f),
                            selected = true,
                        ) {
                            Text(text = it.toString())
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
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            CurrentGoalsCard()

            MealsCard()

            WorkoutTypeCard()

        }
    }
}

@Composable
private fun WorkoutTypeCard() {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .size(280.dp)
            .padding(horizontal = 12.dp, vertical = 12.dp),
        contentAlignment = Alignment.TopStart
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            val tip = "Bodybuilding"
            val den = "Chest & Triceps"

            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Workout type: ")
                }
                append(tip)
            })

            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Workout for the Day: ")
                }
                append(den)
            })

            val exercises = listOf(
                "Bench Press",
                "Incline DB",
                "Cable Fly",
                "Tricep Pushdown",
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

        }

    }
}

@Composable
private fun MealsCard() {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .size(280.dp)
            .padding(horizontal = 12.dp, vertical = 12.dp),
        contentAlignment = Alignment.TopStart
    ) {

        Column {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Today's Meals:",
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {},
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp)
                ) {
                    Text("Favorite Meals")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))


            val meals = listOf("Chicken and Rice", "Oats + Banana")

            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                items(meals.size) {
                    Card(
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = meals[it],
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun CurrentGoalsCard() {
    Card(
        modifier = Modifier.size(280.dp).padding(16.dp),
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
                " Current Goal: Cut \n Protein: 160g \n Carbs: 380g \n Fat: 40g",
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {}) {

                Text("Add Meal")

            }

        }

    }
}