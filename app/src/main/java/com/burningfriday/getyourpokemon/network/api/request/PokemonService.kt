package com.burningfriday.getyourpokemon.network.api.request

import com.burningfriday.getyourpokemon.network.api.model.PokemonInfo
import com.burningfriday.getyourpokemon.network.api.response.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
    ): PokemonResponse

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(
        @Path("name") name: String,
    ): PokemonInfo

}