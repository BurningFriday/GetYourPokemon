package com.burningfriday.getyourpokemon.modern.data.repository

import com.burningfriday.getyourpokemon.network.api.model.PokemonInfo
import com.burningfriday.getyourpokemon.network.api.response.PokemonResponse

interface PokemonRepository {
    suspend fun fetchPokemonList(
        limit: Int,
        offset: Int
    ): PokemonResponse

    suspend fun fetchPokemonInfo(
        name: String
    ): PokemonInfo
}