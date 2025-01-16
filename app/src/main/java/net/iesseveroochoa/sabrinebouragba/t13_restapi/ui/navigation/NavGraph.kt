package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.components.BottomBar
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.favoritos.FavoritosScreen
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.home.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable(HomeDestination.toString()) {
                HomeScreen()
            }

            composable(FavoritosDestination.toString()) {
                FavoritosScreen()
            }
        }
    }
}