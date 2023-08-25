package com.example.rickandmotry.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyViewModel {
    private val _name = MutableLiveData<String>()

    val name: LiveData<String> = _name

    val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/character/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    val retrofitAPI = retrofit.create(RetrofitAPI::class.java)

    fun fetchCharacterName() {
        CoroutineScope(Dispatchers.IO).launch {
            val character = retrofitAPI.getCharacter()
            _name.postValue(character.name)
        }
    }
}