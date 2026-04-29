package com.spirovski.kentapp.di

import com.spirovski.kentapp.screens.mealdescription.MealDescriptionViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val sharedModule = module {
    viewModelOf(::MealDescriptionViewModel)
}