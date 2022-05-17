package com.example.demo.domain.model

import com.google.gson.annotations.SerializedName

data class ResponsePokemonDetail (
	@SerializedName("abilities") val abilities : List<Abilities>,
	@SerializedName("base_experience") val base_experience : Int
)

data class Abilities (
	@SerializedName("ability") val ability : Ability,
	@SerializedName("is_hidden") val is_hidden : Boolean,
	@SerializedName("slot") val slot : Int
)

data class Ability (
	@SerializedName("name") val name : String,
	@SerializedName("url") val url : String
)