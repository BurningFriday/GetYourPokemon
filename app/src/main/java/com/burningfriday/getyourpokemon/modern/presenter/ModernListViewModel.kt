package com.burningfriday.getyourpokemon.modern.presenter

import androidx.lifecycle.viewModelScope
import com.burningfriday.getyourpokemon.common.BaseViewModel
import com.burningfriday.getyourpokemon.modern.domain.PokemonListUseCase
import com.burningfriday.getyourpokemon.network.api.model.Pokemon
import com.burningfriday.getyourpokemon.network.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ModernListViewModel @Inject constructor(
    private val pokemonListUseCase: PokemonListUseCase
) : BaseViewModel() {

//    private var pokemonRepository: PokemonRepository = PokemonRepository()

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList = _pokemonList.asStateFlow()

//    suspend fun fetchPokemonList(limit: Int, offset: Int) {
//        _pokemonList.emit(pokemonRepository.getPokemonList(limit, offset).results)
//    }

    fun fetchPokemonList(limit: Int, offset: Int) {
        viewModelScope.launch {
            _pokemonList.emit(pokemonListUseCase(PokemonListUseCase.Params(limit, offset)).results)
        }
    }


}