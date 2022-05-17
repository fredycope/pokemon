package com.example.demo.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.domain.model.Abilities
import com.example.demo.domain.model.Results
import com.example.demo.domain.usecase.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getPokemonDetailUseCase: GetPokemonDetailUseCase) : ViewModel() {

    private val _pokemonDetail =  MutableLiveData<List<Abilities>>()
    val pokemonDetail: LiveData<List<Abilities>> get() = _pokemonDetail

    fun getPokemonDetail(url: String){
        viewModelScope.launch {
            getPokemonDetailUseCase.getPokemonDetail(url).onEach {
               _pokemonDetail.postValue(it.abilities)
            }.launchIn(viewModelScope)
        }
    }
}