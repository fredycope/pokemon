package com.example.demo.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.domain.model.ResponsePokemon
import com.example.demo.domain.model.Results
import com.example.demo.domain.usecase.GetPokemonInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getPokemonInformationUseCase: GetPokemonInformationUseCase): ViewModel() {
    private val _pokemonInformation =  MutableLiveData<List<Results>>()
    val pokemonInformation:  LiveData<List<Results>> get() = _pokemonInformation

    fun getPokemon(){
        viewModelScope.launch {
            getPokemonInformationUseCase.getPokemonInformation().onEach {
                _pokemonInformation.postValue(it.results)
            }.launchIn(viewModelScope)
        }
    }
}