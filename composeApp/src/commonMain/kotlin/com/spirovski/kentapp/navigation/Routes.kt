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
    object Home : Routes

    @Serializable
    object Meals: Routes

    @Serializable
    object MealDescript

    @Serializable
    object Profile

    @Serializable
    object Workout
}