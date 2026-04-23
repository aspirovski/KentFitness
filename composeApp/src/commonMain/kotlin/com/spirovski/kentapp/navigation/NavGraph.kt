package com.spirovski.kentapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.spirovski.kentapp.screens.HomeScrn
import com.spirovski.kentapp.screens.MealDescpt
import com.spirovski.kentapp.screens.MealsAll
import com.spirovski.kentapp.screens.ProfileScrn
import com.spirovski.kentapp.screens.WorkoutScrn

var navController: NavHostController? = null

@Composable
fun NavGraph() {

    navController = rememberNavController()

    NavHost(
        navController = navController!!,
        startDestination = Routes.Home
    ) {

        composable<Routes.Home> {
            HomeScrn()
        }

        composable<Routes.Meals> {
            MealsAll()
        }

        composable<Routes.MealDescript> {
            MealDescpt()
        }

        composable<Routes.Profile> {
            ProfileScrn()
        }

        composable<Routes.Workout> {
            WorkoutScrn()
        }

    }

}