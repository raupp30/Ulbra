package com.example.apk_as.data.network

import com.example.apk_as.data.network.response.ResultsResponse
import retrofit2.http.GET

interface CharactersApi {
    @GET("character")
    suspend fun fetchCharacters(): ResultsResponse
}