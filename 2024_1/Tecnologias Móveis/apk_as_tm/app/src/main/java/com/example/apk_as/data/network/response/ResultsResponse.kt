package com.example.apk_as.data.network.response

import com.google.gson.annotations.SerializedName

data class ResultsResponse (
    @SerializedName("results")
    val charactersResult: List<CharactersResponse>
)