package com.burningfriday.getyourpokemon

import com.burningfriday.getyourpokemon.common.BaseViewModel
import com.burningfriday.getyourpokemon.network.api.model.Pokemon
import com.burningfriday.getyourpokemon.network.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ModernListViewModel @Inject constructor() : BaseViewModel() {

    private var pokemonRepository: PokemonRepository = PokemonRepository()

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList = _pokemonList.asStateFlow()

    suspend fun fetchPokemonList(limit: Int, offset: Int) {
        _pokemonList.emit(pokemonRepository.getPokemonList(limit, offset).results)
    }


}