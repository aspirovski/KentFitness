package com.spirovski.kentapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Meal(
    val name: String = "",
    val recipe: String = "",
    val protein: String = "",
    val carbs: String = "",
    val fat: String = ""
)
