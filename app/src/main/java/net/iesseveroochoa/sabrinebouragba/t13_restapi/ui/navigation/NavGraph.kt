package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.navigation

import android.net.Uri
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
import com.google.gson.Gson
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.Personaje
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.components.BarraNavegacion
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.components.NavigationItem
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.detalle.DetalleScreen
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
            // Función composable para la pantalla de inicio
            composable(HomeDestination.route) {
                HomeScreen(onPersonajeClick = { personaje ->
                    // Convertir el objeto Personaje a JSON y codificarlo para la navegación
                    val personajeJson = Uri.encode(personajeToJson(personaje))
                    navController.navigate("detalle/$personajeJson")
                })
            }

            // Función composable para la pantalla de detalle
            composable("detalle/{personajeJson}") { backStackEntry ->
                val personajeJson = backStackEntry.arguments?.getString("personajeJson")
                if (personajeJson != null) {
                    // Decodificar la cadena JSON y convertirla de nuevo a un objeto Personaje
                    val decodedJson = Uri.decode(personajeJson)
                    val personaje = jsonToPersonaje(decodedJson)
                    DetalleScreen(
                        personaje = personaje,
                        onVolver = { navController.popBackStack() } // Navegar hacia atrás cuando se presiona el botón de volver
                    )
                }
            }

            // Función composable para la pantalla de favoritos
            composable(FavoritosDestination.route) {
                FavoritosScreen()
            }
        }
    }
}

// Convertir el objeto Personaje a JSON
fun personajeToJson(personaje: Personaje): String {
    val gson = Gson()
    return gson.toJson(personaje)
}

// Decodificar la cadena JSON a un objeto Personaje
fun jsonToPersonaje(json: String): Personaje {
    val gson = Gson()
    return gson.fromJson(json, Personaje::class.java)
}

@Preview(showSystemUi = true)
@Composable
fun AppNavigationPreview() {
    AppNavigation()
}