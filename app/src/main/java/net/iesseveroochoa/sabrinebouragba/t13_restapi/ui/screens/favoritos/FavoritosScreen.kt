package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.favoritos

import androidx.compose.foundation.background
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import net.iesseveroochoa.sabrinebouragba.t13_restapi.R
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.Personaje
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.home.HomeViewModel
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.AlienPurple
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.DarkBrown
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.RickBlue
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.SoftPink

@Composable
fun FavoritosScreen(
    modifier: Modifier = Modifier,
    onPersonajeClick: (Personaje) -> Unit = {},
    viewModel: FavoritoViewModel = viewModel()
) {
    val personajesFavoritos = viewModel.personajesFavoritos.collectAsState(initial = emptyList()).value

    val gradient = Brush.linearGradient(
        colors = listOf(DarkBrown, SoftPink),
        start = Offset(0f, 0f),
        end = Offset(1000f, 1000f)
    )
    val PressStartFontFamily = FontFamily(
        Font(R.font.pressstart, FontWeight.Normal),
        Font(R.font.pressstart, FontWeight.Bold)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(16.dp)
        ,
    ) {
        Text(
            text = "Favoritos",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontFamily = PressStartFontFamily,
            color = RickBlue,
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(personajesFavoritos.size) { index ->
                val personajeFavorito = personajesFavoritos[index]
                PersonajeFavoritoItem(
                    personaje = personajeFavorito.toModel(),
                    onItemClick = { onPersonajeClick(personajeFavorito.toModel()) },
                    onFavoriteClick = { personaje ->
                        viewModel.eliminarFavorito(personaje)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewFavoritosScreen() {
    FavoritosScreen()
}