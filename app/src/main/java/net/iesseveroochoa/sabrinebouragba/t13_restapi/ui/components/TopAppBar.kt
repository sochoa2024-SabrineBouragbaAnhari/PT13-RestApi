package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.BrightYellow
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.LightGreen
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.MortyYellow
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.PortalGreen
import net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.theme.ToxicGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    tituloPantalla: String,
    puedeNavegarAtras: Boolean,
    navegarAtras: () -> Unit = {},
) {

    val gradient = Brush.linearGradient(
        colors = listOf(BrightYellow, MortyYellow, PortalGreen),
        start = Offset(25f, 10f),
        end = Offset(1000f, 100f)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(gradient)
    ) {
        TopAppBar(
            title = {
                Text(text = tituloPantalla)
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Transparent,
            ),
            navigationIcon = {
                if (puedeNavegarAtras) {
                    IconButton(onClick = navegarAtras) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás"
                        )
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun AppBarPreview() {
    AppBar(tituloPantalla = "Personajes", puedeNavegarAtras = false)
}