package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import net.iesseveroochoa.sabrinebouragba.t13_restapi.R
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.Personaje
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.AlienPurple
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.BrightYellow
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.PortalGreen
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.RickBlue
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.SoftPink
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.SpaceshipGrey
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.ToxicGreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    onPersonajeClick: (Personaje) -> Unit = {}
) {

    val PressStartFontFamily = FontFamily(
        Font(R.font.pressstart, FontWeight.Normal),
        Font(R.font.pressstart, FontWeight.Bold)
    )

    val gradient = Brush.linearGradient(
        colors = listOf(SoftPink, RickBlue, AlienPurple),
        start = Offset(0f, 0f),
        end = Offset(1000f, 1000f)
    )

    // recuperamos la lista de personajes como PagingItems
    val listaPersonajes = viewModel.personajes.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
        ,
    ) {
        // Encabezado
        Text(
            text = "Rick and Morty",
            fontFamily = PressStartFontFamily,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = PortalGreen,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 10.dp,
                )
        )

        Box(modifier = Modifier
            .padding(
            horizontal = 16.dp,
            vertical = 10.dp,
        )) {
            //Estamos en la carga inicial. No tenemos datos y mostramos un CircularProgressIndicator
            when {
                listaPersonajes.loadState.refresh is LoadState.Loading && (listaPersonajes.itemCount
                == 0) -> {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(60.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
                //Recuperamos datos y no tenemos ninguno mostramos un mensaje
                listaPersonajes.loadState.append is LoadState.NotLoading && listaPersonajes.itemCount
                        == 0 -> {
                    Text(text = "No hay personajes")
                }
                //Si tenemos datos pero no se han podido recuperar del error
                listaPersonajes.loadState.hasError -> {
                    Text(text = "Error: ")
                }
                //Tenemos nuevos datos, los mostramos en la lista
                else -> {
                    //observa el Logcat los elementos que tenemos actualmente
                    Log.i("T11-REstApi", "Personajes cargados en el LazyColumn: ${listaPersonajes.itemCount}")
                    //LazyColumn para mostrar los elementos
                    LazyColumn(modifier = modifier) {
                        items(listaPersonajes.itemCount) { index ->
                            listaPersonajes[index]?.let {
                                PersonajeItem(
                                    personaje = it,
                                    onItemClick = { onPersonajeClick(it) }
                                )
                            }
                        }
                    }
                    //si se hace scroll y llega al final mostramos una barra de progreso.
                    // No se apreciará si la conexión es muy buena
                    if (listaPersonajes.loadState.append is LoadState.Loading) {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .size(64.dp)
                                    .align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}