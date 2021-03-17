package com.pritim.anggotarestapi.Config

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkModule {

    fun getRetrofit() : Retrofit{

        return Retrofit.Builder().baseUrl("http://10.0.2.2/BackendAppKotlin/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun service() : ApiService = getRetrofit().create(ApiService::class.java)
}