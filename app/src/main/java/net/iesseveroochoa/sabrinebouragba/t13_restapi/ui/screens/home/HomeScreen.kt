package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.iesseveroochoa.sabrinebouragba.t13_restapi.R
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.api.NetworkService
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.RespuestaRickMorty
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.RickBlue
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.SpaceshipGrey

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    var respuesta by remember {
        mutableStateOf<RespuestaRickMorty?>(null)
    }

    LaunchedEffect(true) {
        respuesta = NetworkService.servicioRickMorty.listaPersonajes().body()
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp),
    ) {
        Text(
            text = "Rick and Morty",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            color = RickBlue,
            modifier = Modifier
                .fillMaxWidth()
        )

        Text(
            text = if (respuesta == null) {
                "Sin datos"
            } else {
                respuesta.toString()
            }
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}