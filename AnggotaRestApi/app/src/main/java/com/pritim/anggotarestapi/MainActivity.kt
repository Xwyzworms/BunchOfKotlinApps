package com.pritim.anggotarestapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.pritim.anggotarestapi.Config.NetworkModule
import com.pritim.anggotarestapi.Model.getdata.DataItem
import com.pritim.anggotarestapi.Model.getdata.ResponseGetdata
import com.pritim.anggotarestapi.adapter.DataAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview : RecyclerView = findViewById(R.id.recyclerViewLayout)
        flAddData.setOnClickListener{
            val intent = Intent(this,InputActivity::class.java)
            startActivity(intent)
        }
        val listAnggota  : Call<ResponseGetdata> =  NetworkModule.service().getData()
        listAnggota.enqueue(object : Callback<ResponseGetdata>{
            override fun onResponse(call: Call<ResponseGetdata>, response: Response<ResponseGetdata>) {
                val item = response.body()?.data
                val adapter = DataAdapter(item, object : DataAdapter.OnClickListener {
                    override fun detail(item: DataItem?) {
                       Toast.makeText(applicationContext,"Detail nya nanti", Toast.LENGTH_LONG) .show()
                    }

                })
                recyclerview.adapter = adapter
            }
            override fun onFailure(call: Call<ResponseGetdata>, t: Throwable) {
                Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
            }



        })
    }



}