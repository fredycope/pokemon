package com.example.demo.data.repository

import com.example.demo.data.network.RetrofitService
import com.example.demo.domain.model.ResponsePokemon
import com.example.demo.domain.model.ResponsePokemonDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PokemonRepository(private val retrofitService: RetrofitService) {
    suspend fun getPokemonInformsation(): Flow<ResponsePokemon> = flow {
        val result = retrofitService.getPokemon()
        emit(result)
    }.flowOn(Dispatchers.IO)

    suspend fun getPokemonDetail(url: String): Flow<ResponsePokemonDetail> = flow {
        val result = retrofitService.getPokemonDetail(url)
        emit(result)
    }.flowOn(Dispatchers.IO)
}