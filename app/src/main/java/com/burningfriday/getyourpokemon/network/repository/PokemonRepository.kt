package com.burningfriday.getyourpokemon.network.repository

import android.util.Log
import com.burningfriday.getyourpokemon.network.api.PokemonRetrofitFactory
import com.burningfriday.getyourpokemon.network.api.model.PokemonInfo
import com.burningfriday.getyourpokemon.network.api.request.PokemonService
import com.burningfriday.getyourpokemon.network.api.response.PokemonResponse

/**
 * @author Hyunwoo Choi
 */
class PokemonRepository {

    private val service: PokemonService by lazy {
        PokemonRetrofitFactory.build().create(PokemonService::class.java)
    }

    suspend fun getPokemonList(limit: Int, offset: Int): PokemonResponse {
        return service.fetchPokemonList(limit, offset)
    }

    suspend fun getPokemonInfo(name: String): PokemonInfo {
        return service.fetchPokemonInfo(name)
    }

}