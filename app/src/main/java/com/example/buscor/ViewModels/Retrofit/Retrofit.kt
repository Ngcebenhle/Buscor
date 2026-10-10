package com.example.buscor.ViewModels.Retrofit

import com.example.buscor.Model.APIServices.APIServices
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {


    object RetrofitInstance {

        val lenientGson = GsonBuilder()
            .setLenient()
            .create()
        private const val BASE_URL = "http://192.168.0.39:3000/api/restaurant/"

        val api: APIServices by lazy {
            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(lenientGson))
                .build()
                .create(APIServices::class.java)

        }
    }

}

//192.168.0.99