package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import net.iesseveroochoa.sabrinebouragba.t13_restapi.R
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.Personaje
import java.util.Date

@Composable
fun PersonajeItem(
    personaje: Personaje,
    onItemClick: () -> Unit = {}
) {
    val gradient = Brush.linearGradient(
        colors = listOf(Color(0xFF43C6AC), Color(0xFF191654)),
        start = Offset(0f, 0f),
        end = Offset(1000f, 1000f)
    )

    Card(
        modifier = Modifier
            .height(150.dp)
            .width(350.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(Color.Transparent),
        onClick = onItemClick
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(25.dp))
                .background(gradient)
        ){
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
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
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
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White,
                    )

                    // Especie del personaje
                    Text(
                        text = personaje.especie,
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White
                    )

                    // Estado del personaje
                    Text(
                        text = personaje.estado,
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 16.sp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonajeItem() {
    PersonajeItem(
        personaje = Personaje(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            type = "",
            gender = "Male",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            created = Date()
        )
    )
}