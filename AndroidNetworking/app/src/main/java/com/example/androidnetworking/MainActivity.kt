package com.example.androidnetworking

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidnetworking.adapter.WisataAdapter
import com.example.androidnetworking.model.ResponseServer
import com.example.androidnetworking.model.Wisata
import com.example.androidnetworking.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar: ProgressBar = findViewById(R.id.progressBarGan)
        if (isConnect()) {
            ConfigNetwork().getRetrofit().getDataWisata()
                .enqueue(object : Callback<ResponseServer> {
                    override fun onResponse(
                        call: Call<ResponseServer>,
                        response: Response<ResponseServer>
                    ) {
                        Log.d("Granted Response", response.message())
                        if (response.isSuccessful) {
                            val status: Int? = response.body()?.status_code
                            if (status == 200) {
                                progressBar.visibility = View.GONE
                                val data: Array<Wisata>? = response.body()?.data
                                showData(data)
                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                        progressBar.visibility = View.GONE
                        t.message?.let { Log.d("Error Response", it) }
                    }
                })
        }
        else{
            progressBar.visibility=View.GONE
            Toast.makeText(this,"GA ADA ITNENTEt",Toast.LENGTH_LONG).show()

        }
    }

        private fun showData(data: Array<Wisata>?) {
            val listWisata: RecyclerView = findViewById(R.id.rlShowData)
            listWisata.adapter = WisataAdapter(data)
        }

        private fun isConnect(): Boolean {
            val connect: ConnectivityManager =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkinfo = connect.activeNetworkInfo
            if (networkinfo != null && networkinfo.isConnected){
                Toast.makeText(this,networkinfo.isConnected.toString(),Toast.LENGTH_LONG).show()

                return true
            }

            return false

        }

    }