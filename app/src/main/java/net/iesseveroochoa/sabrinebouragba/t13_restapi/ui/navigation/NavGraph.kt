package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.components.BarraNavegacion
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.components.NavigationItem
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.favoritos.FavoritosScreen
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.home.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    fun listaDestinos() = listOf(
        NavigationItem(//pantalla principal
            HomeDestination.route,
            "Inicio",
            Icons.Filled.Home,
            Icons.Outlined.Home
        ),
        NavigationItem(//favoritos
            FavoritosDestination.route,
            "Favoritos",
            Icons.Filled.Favorite,
            Icons.Outlined.FavoriteBorder
        )
    )

    Scaffold(
        bottomBar = {
            BarraNavegacion(
                items = listaDestinos(),
                navController = navController
            )
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = HomeDestination.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(HomeDestination.route) {
                HomeScreen()
            }

            composable(FavoritosDestination.route) {
                FavoritosScreen()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppNavigationPreview() {
    AppNavigation()
}