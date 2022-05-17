package com.example.demo.data.network

import com.example.demo.domain.model.ResponsePokemon
import com.example.demo.domain.model.ResponsePokemonDetail
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitService {

    @GET("pokemon")
    suspend fun getPokemon(): ResponsePokemon

    @GET
    suspend fun getPokemonDetail(@Url url: String): ResponsePokemonDetail
}