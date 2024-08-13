package com.example.apk_as.data.datasources

import com.example.apk_as.data.network.CharactersApi
import com.example.apk_as.data.network.response.ResultsResponse
import javax.inject.Inject

class CharactersDataSource @Inject constructor(
    private val api: CharactersApi
) {
    suspend fun fetchCharacters(): ResultsResponse {
        return api.fetchCharacters()
    }
}