package com.burningfriday.getyourpokemon.modern.data.repository.impl

import com.burningfriday.getyourpokemon.modern.data.repository.PokemonRepository
import com.burningfriday.getyourpokemon.modern.data.service.PokemonService
import com.burningfriday.getyourpokemon.network.api.model.PokemonInfo
import com.burningfriday.getyourpokemon.network.api.response.PokemonResponse
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonService: PokemonService
) : PokemonRepository {

    override suspend fun fetchPokemonList(limit: Int, offset: Int): PokemonResponse {
        return pokemonService.fetchPokemonList(limit = limit, offset = offset)
    }

    override suspend fun fetchPokemonInfo(name: String): PokemonInfo {
        return pokemonService.fetchPokemonInfo(name = name)
    }

}