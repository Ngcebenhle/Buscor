package com.example.buscor.ViewModels.Retrofit

import com.example.buscor.Model.APIServices.APIServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    object RetrofitInstance {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com//"

        val api: APIServices by lazy {
            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIServices::class.java)

        }
    }



}