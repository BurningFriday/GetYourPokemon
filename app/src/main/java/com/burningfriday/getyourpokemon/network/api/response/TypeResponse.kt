package com.burningfriday.getyourpokemon.network.api.response

import com.burningfriday.getyourpokemon.network.api.model.Type
import com.google.gson.annotations.SerializedName

data class TypeResponse(
    @SerializedName("slot") val slot: Int,
    @SerializedName("type") val type: Type,
)