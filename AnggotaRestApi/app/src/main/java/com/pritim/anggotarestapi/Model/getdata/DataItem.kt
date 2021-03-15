package com.pritim.anggotarestapi.Model.getdata

import com.google.gson.annotations.SerializedName

data class DataItem(

        @field:SerializedName("nama")
        val nama: String? = null,

        @field:SerializedName("nohp")
        val nohp: String? = null,

        @field:SerializedName("id")
        val id: String? = null,

        @field:SerializedName("alamat")
        val alamat: String? = null
)