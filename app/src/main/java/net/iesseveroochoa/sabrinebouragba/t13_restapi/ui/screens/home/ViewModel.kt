package net.iesseveroochoa.sabrinebouragba.t13_restapi.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.api.Repository

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
}