package com.pritim.anggotarestapi.Model.action

import com.google.gson.annotations.SerializedName

data class ResponseAction(

	@field:SerializedName("message")
	val message: List<Any?>? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)
