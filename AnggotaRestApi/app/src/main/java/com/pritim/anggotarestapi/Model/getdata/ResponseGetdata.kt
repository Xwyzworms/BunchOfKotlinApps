package com.pritim.anggotarestapi.Model.getdata

import com.google.gson.annotations.SerializedName

data class ResponseGetdata(

		@field:SerializedName("data")
	val data: List<DataItem?>? = null,

		@field:SerializedName("isSucess")
	val isSucess: Boolean? = null,

		@field:SerializedName("message")
	val message: String? = null
)

