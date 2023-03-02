package com.example.lovecalculat.remote

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoveService {
    val retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create(Gson())).build()

    val api = retrofit.create(LoveApi::class.java)
}