package com.example.apk_as.data.repositories

import com.example.apk_as.data.datasources.CharactersDataSource
import com.example.apk_as.data.network.response.toModel
import com.example.apk_as.data.Character
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val charactersDataSource: CharactersDataSource
) {
    suspend fun fetchCharacters(): List<Character> {
        return charactersDataSource
            .fetchCharacters()
            .charactersResult.map { item -> item.toModel() }
    }
}