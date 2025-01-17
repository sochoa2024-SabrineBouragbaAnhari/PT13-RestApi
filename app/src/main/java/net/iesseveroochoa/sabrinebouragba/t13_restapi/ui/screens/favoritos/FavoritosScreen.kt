package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.favoritos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.iesseveroochoa.sabrinebouragba.t13_restapi.R

@Composable
fun FavoritosScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
    ) {
        Text(
            text = R.string.label_favoritos.toString(),
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun FavoritosScreenPreview() {
    FavoritosScreen()
}