package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.api.Repository
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.entity.PersonajeFavorito
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.Personaje

class HomeViewModel: ViewModel() {
    val MAX_ITEMS = 10
    val PREFETCH_DISTANCE = 3
    val personajes = Pager(
        config = PagingConfig(
            pageSize = MAX_ITEMS,
            prefetchDistance = PREFETCH_DISTANCE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            Repository.getPersonajesApiPagingSource()
        }
    )
        // Flow de la paginación
        .flow
        // Mantener el estado de la paginación
        .cachedIn(viewModelScope)


    private val _idsFavoritos = MutableStateFlow<List<Int>>(emptyList())
    val idsFavoritos: StateFlow<List<Int>> = _idsFavoritos

    init {
        viewModelScope.launch {
            Repository.obtenerIdsFavoritos().collect { ids ->
                _idsFavoritos.value = ids
            }
        }
    }

    // Método para alternar entre agregar y eliminar un favorito
    fun toggleFavorito(personaje: Personaje) {
        viewModelScope.launch {
            if (_idsFavoritos.value.contains(personaje.id)) {
                Repository.eliminarFavorito(personaje.toEntity())
            } else {
                Repository.agregarFavorito(personaje.toEntity())
            }
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