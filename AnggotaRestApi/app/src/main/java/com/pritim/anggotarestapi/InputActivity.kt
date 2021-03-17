package com.pritim.anggotarestapi

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pritim.anggotarestapi.Config.NetworkModule
import com.pritim.anggotarestapi.Model.action.ResponseAction
import kotlinx.android.synthetic.main.insertlayout_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insertlayout_activity)


        btnInputSabmit.setOnClickListener {
            inputData(etInputNama.text.toString(),
                      etInputNoHp.text.toString(),
                      etInputAlamat.text.toString())
        }
        btnInputBatal.setOnClickListener {
            finish()
        }
    }

    fun inputData(nama : String?, noHp : String? , alamat : String?) {

        val input = NetworkModule.service().insertData(nama ?: "", noHp ?: "", alamat ?: "")
        input.enqueue(object : Callback<ResponseAction> {
            override fun onResponse(call: Call<ResponseAction>, response: Response<ResponseAction>) {
            Toast.makeText(applicationContext,"Data Berhasil Dimasukan",Toast.LENGTH_LONG).show()

            }


            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
            Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
            }


        } )


    }



}