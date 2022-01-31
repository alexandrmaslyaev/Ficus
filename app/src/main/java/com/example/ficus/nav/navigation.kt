package com.example.ficus.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ficus.ui.plants.PlantsScreen

@Composable
fun CreateNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavDestination.PLANTS) {
        composable(NavDestination.PLANTS) { PlantsScreen() }
    }
}