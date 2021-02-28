package com.example.androidnetworking.network

import com.example.androidnetworking.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface WisataService {
    @GET("api?action=findAll")
    fun getDataWisata(): Call<ResponseServer>
}