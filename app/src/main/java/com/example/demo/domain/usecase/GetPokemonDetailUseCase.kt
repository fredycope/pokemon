package com.example.demo.domain.usecase

import com.example.demo.data.repository.PokemonRepository
import com.example.demo.domain.model.ResponsePokemonDetail
import kotlinx.coroutines.flow.Flow

class GetPokemonDetailUseCase(private val repository: PokemonRepository) {
    suspend fun getPokemonDetail(url: String): Flow<ResponsePokemonDetail> = repository.getPokemonDetail(url)
}