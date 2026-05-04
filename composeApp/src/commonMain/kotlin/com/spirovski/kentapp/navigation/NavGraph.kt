package com.spirovski.kentapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.spirovski.kentapp.screens.EditScreen
import com.spirovski.kentapp.screens.HomeScrn
import com.spirovski.kentapp.screens.KentSplashScreen
import com.spirovski.kentapp.screens.mealdescription.MealDescpt
import com.spirovski.kentapp.screens.MealsAll
import com.spirovski.kentapp.screens.ProfileScrn
import com.spirovski.kentapp.screens.WorkoutScrn
import com.spirovski.kentapp.screens.login.LoginScreen
import com.spirovski.kentapp.screens.mealdescription.MealDescriptionViewModel
import com.spirovski.kentapp.screens.register.RegisterScreen

var navController: NavHostController? = null

@Composable
fun NavGraph() {

    val viewModel = viewModel<MealDescriptionViewModel>()

    navController = rememberNavController()

    NavHost(
        navController = navController!!,
        startDestination = Routes.Splash
    ) {

        composable<Routes.Splash> {
            KentSplashScreen()
        }

        composable<Routes.Login> {
            LoginScreen()
        }

        composable<Routes.Register> {
            RegisterScreen()
        }

        composable<Routes.Home> {
            HomeScrn()
        }

        composable<Routes.Meals> {
            MealsAll()
        }

        composable<Routes.MealDescript> { backStackEntry ->
            val route = backStackEntry.toRoute<Routes.MealDescript>()
            MealDescpt(initialMealName = route.mealName)
        }

        composable<Routes.Profile> {
            ProfileScrn()
        }

        composable<Routes.Workout> { backStackEntry ->
            val route = backStackEntry.toRoute<Routes.Workout>()
            WorkoutScrn(showWelcomeSnackbar = route.showWelcomeSnackbar)
        }

        composable<Routes.Edit> {
            EditScreen()
        }

    }

}