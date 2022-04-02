package com.burningfriday.getyourpokemon.network.api.response

import com.burningfriday.getyourpokemon.network.api.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<Pokemon>,
)