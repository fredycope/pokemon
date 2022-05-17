package com.example.demo.domain.usecase

import com.example.demo.data.repository.PokemonRepository
import com.example.demo.domain.model.ResponsePokemon
import kotlinx.coroutines.flow.Flow

class GetPokemonInformationUseCase(private var repository: PokemonRepository) {
    suspend fun getPokemonInformation(): Flow<ResponsePokemon> = repository.getPokemonInformsation()
}