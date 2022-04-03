package com.burningfriday.getyourpokemon.network.api.model

import com.burningfriday.getyourpokemon.network.api.response.TypeResponse
import com.google.gson.annotations.SerializedName

data class PokemonInfo(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("base_experience") val experience: Int,
    @SerializedName("types") val types: List<TypeResponse>,
)