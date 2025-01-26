package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.favoritos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.api.Repository
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.entity.PersonajeFavorito
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.Personaje
import java.util.Date

class FavoritoViewModel: ViewModel() {
    private val _personajesFavoritos = MutableStateFlow<List<PersonajeFavorito>>(emptyList())
    val personajesFavoritos: StateFlow<List<PersonajeFavorito>> = _personajesFavoritos

    init {
        viewModelScope.launch {
            Repository.obtenerPersonajesFavoritos().collect { personajes ->
                _personajesFavoritos.value = personajes
            }
        }
    }

    fun agregarFavorito(personaje: Personaje) {
        viewModelScope.launch {
            val personajeFavorito = personaje.toEntity()
            Repository.agregarFavorito(personajeFavorito)
        }
    }

    fun eliminarFavorito(personaje: Personaje) {
        viewModelScope.launch {
            val personajeFavorito = personaje.toEntity()
            Repository.eliminarFavorito(personajeFavorito)
        }
    }
}

// Extensión para convertir un `Personaje` a `PersonajeFavorito`
fun Personaje.toEntity(): PersonajeFavorito {
    return PersonajeFavorito(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        image = image
    )
}

// Extensión para convertir un `PersonajeFavorito` a `Personaje`
fun PersonajeFavorito.toModel(): Personaje {
    return Personaje(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        image = image,
        type = "",
        created = Date()
    )
}