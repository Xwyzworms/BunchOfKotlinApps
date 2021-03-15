package com.pritim.anggotarestapi.Config

import com.pritim.anggotarestapi.Model.action.ResponseAction
import com.pritim.anggotarestapi.Model.getdata.ResponseGetdata
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    //getData
    @GET("getData.php")
    fun getData() : Call<ResponseGetdata>

    @GET("getData.php")
    fun getData(@Query("id") id : String) : Call<ResponseAction>
    //insert
    @FormUrlEncoded
    @POST("insert.php")
    fun insertData( @Field("nama") nama : String ,
                    @Field("nohp") nohp : String,
                    @Field("alamat") alamat: String ) : Call<ResponseAction>

    @FormUrlEncoded
    @POST("update.php")
    fun updateData( @Field("id") id : String,
                    @Field("nama") nama: String,
                    @Field("alamat") alamat : String,
                    @Field("nohp") nohp: String) : Call<ResponseAction>

    @FormUrlEncoded
    @POST("delete.php")
    fun deleteData( @Field("id") id : String) : Call<ResponseAction>


}