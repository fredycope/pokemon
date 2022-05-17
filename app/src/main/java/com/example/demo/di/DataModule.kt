package com.example.demo.di

import com.example.demo.data.network.RetrofitService
import com.example.demo.data.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun pokemonRepository(retrofitService: RetrofitService): PokemonRepository{
        return PokemonRepository(retrofitService)
    }
}