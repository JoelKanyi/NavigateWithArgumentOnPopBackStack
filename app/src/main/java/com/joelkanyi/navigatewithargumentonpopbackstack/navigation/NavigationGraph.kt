package com.joelkanyi.navigatewithargumentonpopbackstack.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.joelkanyi.navigatewithargumentonpopbackstack.screen.HomeScreen
import com.joelkanyi.navigatewithargumentonpopbackstack.screen.TakeWaterScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = "home") {
        composable(
            route = "home",
            arguments = listOf(
                navArgument(name = "takenWater") {
                    type = NavType.BoolType
                    defaultValue = false
                },
            ),
        ) { backStackEntry ->

            val takenWater = backStackEntry.savedStateHandle.getStateFlow(
                "takenWater",
                initialValue = false,
            ).collectAsState().value

            HomeScreen(
                navController = navController,
                takenWater = takenWater,
            )
        }

        composable(route = "take_water") {
            TakeWaterScreen(
                navController = navController,
            )
        }
    }
}
