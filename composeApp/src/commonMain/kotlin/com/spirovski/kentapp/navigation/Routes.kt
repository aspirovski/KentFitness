package com.spirovski.kentapp.navigation

import kotlinx.serialization.Serializable

fun navigateToScreen(route: Any) {
    navController?.navigate(route)
}

fun navigateBack() {
    navController?.navigateUp()
}

sealed interface Routes {

    @Serializable
    object Splash : Routes

    @Serializable
    object Home : Routes

    @Serializable
    object Meals: Routes

    @Serializable
    data class MealDescript(val mealName: String) : Routes

    @Serializable
    object Profile : Routes

    @Serializable
    object Workout : Routes
}