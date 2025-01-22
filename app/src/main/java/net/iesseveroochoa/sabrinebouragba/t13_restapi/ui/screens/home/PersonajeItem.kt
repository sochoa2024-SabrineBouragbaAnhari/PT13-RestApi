package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import net.iesseveroochoa.sabrinebouragba.t13_restapi.R
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.Personaje
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.RickBlue

@Composable
fun PersonajeItem(
    modifier: Modifier = Modifier,
    personaje: Personaje,
    onItemClick: () -> Unit = {},
    color: Color = RickBlue
) {
    Card(
        modifier = modifier
            .height(120.dp)
            .width(300.dp),
        colors = CardDefaults.cardColors(color)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen del personaje
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(personaje.image)
                    .build(),
                placeholder = painterResource(R.drawable.loading),
                error = painterResource(R.drawable.noimage),
                contentDescription = personaje.name,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(100.dp)
            )

            // Información de los personajes
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                // Nombre del personaje
                Text(
                    text = personaje.name,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White,
                )

                // Especie del personaje
                Text(
                    text = personaje.especie,
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )

                // Estado del personaje
                Text(
                    text = personaje.estado,
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
            }
        }
    }
}