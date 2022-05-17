package com.example.demo.domain.model

import com.google.gson.annotations.SerializedName

data class ResponsePokemon (
    @SerializedName("count") var count : Int? = 0,
    @SerializedName("next") var next : String? = "",
    @SerializedName("previous") var previous : String? = null,
    @SerializedName("results") var results  : ArrayList<Results> = arrayListOf()
)

data class Results (
    @SerializedName("name" ) var name : String? = "",
    @SerializedName("url"  ) var url  : String? = ""
)

