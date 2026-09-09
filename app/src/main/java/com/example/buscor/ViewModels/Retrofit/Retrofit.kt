package com.example.buscor.ViewModels.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com//")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    val apiInterface by lazy {
//        retrofit.create(ApiInterface::class.java)
//    }
}