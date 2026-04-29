package com.spirovski.kentapp.screens.mealdescription

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.spirovski.kentapp.model.Meal
import org.koin.core.component.KoinComponent

class MealDescriptionViewModel : ViewModel(), KoinComponent {

    val meals = mutableStateListOf<Meal>()

    fun addMeal(obrok: Meal) {
        meals.add(obrok)
    }



}