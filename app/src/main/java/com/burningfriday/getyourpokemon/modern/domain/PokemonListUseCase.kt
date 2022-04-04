package com.burningfriday.getyourpokemon.modern.domain

import com.burningfriday.getyourpokemon.modern.data.repository.PokemonRepository
import com.burningfriday.getyourpokemon.network.api.response.PokemonResponse
import javax.inject.Inject

class PokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    data class Params(val limit: Int, val offset: Int)

    suspend operator fun invoke(params: Params): PokemonResponse =
        pokemonRepository.fetchPokemonList(params.limit, params.offset)

}