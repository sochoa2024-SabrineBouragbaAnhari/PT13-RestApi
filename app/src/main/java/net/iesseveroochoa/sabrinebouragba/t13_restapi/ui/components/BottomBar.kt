package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BottomBar(
    navController: NavHostController
) {
    BottomAppBar {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = "Inicio",
                        modifier = Modifier.size(30.dp)
                    )
                }

                Text(
                    text = "Inicio"
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Filled.FavoriteBorder,
                        contentDescription = "Favoritos",
                        modifier = Modifier.size(30.dp)
                    )
                }
                Text(
                    text = "Favoritos"
                )
            }
        }
    }
}