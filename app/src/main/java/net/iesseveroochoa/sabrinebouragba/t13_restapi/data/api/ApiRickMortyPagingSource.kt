package net.iesseveroochoa.sabrinebouragba.t13_restapi.data.api

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import net.iesseveroochoa.sabrinebouragba.t13_restapi.data.model.Personaje

class ApiRickMortyPagingSource():
    PagingSource<Int, Personaje>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Personaje> {
        return try {
            //si es null es que es la primera, en otro caso es la siguiente
            val nextPage = params.key ?: 1
            //Le pedimos al servicio la siguiente página de personajes
            val siguientesPersonajesApi =
                NetworkService.servicioRickMorty.listaPersonajes(nextPage)
            //obtenemos la lista de personajes según hemos definido el modelo
            val personajes = siguientesPersonajesApi.body()?.listaPersonajes
            //observa en el logcat como carga las páginas
            Log.i("T11-REstApi", "Personajes cargados: ${personajes?.size}, página: $nextPage")
            //devolvemos el resultado indicando:
            LoadResult.Page(
                //resultado de la lista de personajes
                data = personajes!!,
                //La clave de la página anterior. Si es la primera página, no hay página  anterior.
                prevKey = if (nextPage == 1) null else nextPage - 1,
                //La clave de la página siguiente. Si no hay más páginas, es null.
                nextKey = if (personajes!!.isEmpty()) null else nextPage + 1
            )
            //Hemos tenido un error
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Personaje>): Int? {
        //será la última posición en la que estabamos
        return state.anchorPosition
    }
}