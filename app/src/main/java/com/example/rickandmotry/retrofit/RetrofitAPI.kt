package com.example.rickandmotry.retrofit

import retrofit2.http.GET

interface RetrofitAPI {
    @GET("2")
    suspend fun getCharacter(): Character
}