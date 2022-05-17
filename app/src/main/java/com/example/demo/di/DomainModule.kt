package com.example.demo.di

import com.example.demo.data.repository.PokemonRepository
import com.example.demo.domain.usecase.GetPokemonDetailUseCase
import com.example.demo.domain.usecase.GetPokemonInformationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
     fun getPokemonInformation(repository: PokemonRepository): GetPokemonInformationUseCase = GetPokemonInformationUseCase(repository)

    @Provides
    fun getPokemonDetail(repository: PokemonRepository): GetPokemonDetailUseCase = GetPokemonDetailUseCase(repository)
}