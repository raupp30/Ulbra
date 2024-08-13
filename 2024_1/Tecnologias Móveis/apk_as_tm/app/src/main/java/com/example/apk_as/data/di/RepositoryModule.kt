package com.example.apk_as.data.di

import com.example.apk_as.data.datasources.CharactersDataSource
import com.example.apk_as.data.repositories.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesCharactersRepository(
        charactersDataSource: CharactersDataSource
    ): CharactersRepository {
        return CharactersRepository(charactersDataSource)
    }
}