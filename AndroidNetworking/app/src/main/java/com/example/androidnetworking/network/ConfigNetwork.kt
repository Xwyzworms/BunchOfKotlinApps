package com.example.androidnetworking.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {
    fun getRetrofit() : WisataService{

        val retrofit  = Retrofit.Builder()
                .baseUrl("http://udacoding.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(WisataService::class.java)
    }
}