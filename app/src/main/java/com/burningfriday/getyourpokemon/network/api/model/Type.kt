package com.burningfriday.getyourpokemon.network.api.model

import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("name") val name: String,
)