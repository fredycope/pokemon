package com.example.demo.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ClientRetrofit {
    var API_BASE_URL = ""

    var httpClient = OkHttpClient.Builder()

    var builder = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create()
        )

    var retrofit = builder
        .client(httpClient.build())
        .build()

    var client: ClientRetrofit = retrofit.create(ClientRetrofit::class.java)
}