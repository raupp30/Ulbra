package com.example.apk_as.data.di

import com.example.apk_as.data.datasources.CharactersDataSource
import com.example.apk_as.data.network.CharactersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesDataSourceModule(
        api: CharactersApi
    ): CharactersDataSource {
        return CharactersDataSource(api)
    }
}