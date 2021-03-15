package com.pritim.anggotarestapi.Config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    fun getRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl("http://192.168.0.113/BackendAppKotlin/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}