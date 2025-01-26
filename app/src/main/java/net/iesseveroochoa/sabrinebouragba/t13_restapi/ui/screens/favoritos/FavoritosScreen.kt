package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.favoritos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.Personaje
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.home.HomeViewModel

@Composable
fun FavoritosScreen(
    modifier: Modifier = Modifier,
    onNoFavorite: (Personaje) -> Unit = {},
    viewModel: FavoritoViewModel = viewModel()
) {
    val personajesFavoritos = viewModel.personajesFavoritos.collectAsState(initial = emptyList()).value

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Favoritos",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(personajesFavoritos.size) { index ->
                val personajeFavorito = personajesFavoritos[index]
                PersonajeFavoritoItem(
                    personaje = personajeFavorito.toModel(),
                    onItemClick = {},
                    onFavoriteClick = { personaje ->
                        viewModel.eliminarFavorito(personaje)
                    }
                )
            }
        }
    }
}