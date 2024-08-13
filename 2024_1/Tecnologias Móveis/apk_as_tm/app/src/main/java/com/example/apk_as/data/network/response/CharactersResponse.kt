package com.example.apk_as.data.network.response

import com.example.apk_as.data.Character



import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String
)

fun CharactersResponse.toModel() = Character(
    name = this.name,
    image = this.image
)


