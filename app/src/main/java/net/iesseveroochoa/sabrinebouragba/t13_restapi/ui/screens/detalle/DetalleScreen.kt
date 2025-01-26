package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.detalle

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import net.iesseveroochoa.sabrinebouragba.t13_restapi.R
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.Personaje
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.components.AppBar
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.LightBeige
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.PortalGreen
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.ToxicGreen
import java.util.Date

@Composable
fun DetalleScreen(
    personaje: Personaje,
    onVolver: () -> Unit = {}
) {

    val gradient = Brush.linearGradient(
        colors = listOf(ToxicGreen, PortalGreen),
        start = Offset(0f, 0f),
        end = Offset(1000f, 1000f)
    )

    val PressStartFontFamily = FontFamily(
        Font(R.font.pressstart, FontWeight.Normal),
        Font(R.font.pressstart, FontWeight.Bold)
    )

    val JollyLodgerFontFamily = FontFamily(
        Font(R.font.jollylodger, FontWeight.Normal),
        Font(R.font.jollylodger, FontWeight.Bold)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBeige),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppBar(
            tituloPantalla = "Detalle Personaje",
            puedeNavegarAtras = true,
            navegarAtras = onVolver
        )

        // Parte superior: Imagen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.42f)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(personaje.image)
                    .build(),
                contentDescription = "Imagen del personaje",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }

        // Parte inferior: Datos
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .background(gradient)
                .padding(16.dp)
                .border(2.dp, Color.Black, RoundedCornerShape(25.dp)),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = personaje.name,
                fontSize = 35.sp,
                fontFamily = PressStartFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = personaje.gender,
                    fontSize = 40.sp,
                    fontFamily = JollyLodgerFontFamily,
                    color = Color.DarkGray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, bottom = 20.dp)
                )

                Text(
                    text = personaje.species,
                    fontSize = 40.sp,
                    color = Color.DarkGray,
                    fontFamily = JollyLodgerFontFamily,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, bottom = 20.dp)
                )

                Text(
                    text = personaje.status,
                    fontSize = 40.sp,
                    fontFamily = JollyLodgerFontFamily,
                    color = Color.DarkGray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, bottom = 20.dp)
                )

                Text(
                    text = personaje.created.toString(),
                    fontSize = 30.sp,
                    fontFamily = JollyLodgerFontFamily,
                    color = Color.DarkGray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun TarjetaPersonajePreview() {
    DetalleScreen(
        personaje =
            Personaje(
                id = 1,
                name = "Rick Sanchez",
                status = "Alive",
                species = "Human",
                type = "",
                gender = "Male",
                image = "",
                created = Date()
            )

    )
}
