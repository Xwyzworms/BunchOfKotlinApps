package com.example.intentions

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSubmit: Button = findViewById<Button>(R.id.btnSubmit)
        val etUmur: EditText = findViewById(R.id.etUmur)
        val etNama: EditText = findViewById(R.id.etNama)
        val etKota: EditText = findViewById(R.id.etKota)
        val btnRequestPermission : Button = findViewById<Button>(R.id.btnRequestPermission)
        Log.d("MainActivity", "Cok Baru insiasi")
        btnSubmit.setOnClickListener {
            val manusia: Manusia = Manusia(
                etNama.text.toString(),
                etUmur.text.toString().toInt(),
                etKota.text.toString()
            )
            val intentObj = Intent(this, SecondActivity::class.java)
            Log.d("MainActivity","$intentObj")
            intentObj.putExtra("EXTRA_MANUSIA", manusia)
            startActivity(intentObj)
        }
        btnRequestPermission.setOnClickListener {
            reqPermissions()
        }
    }


    private fun hasLocationForegroundPermission():Boolean{
        return ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    private fun hasLocationBackgroundPermission():Boolean {
        return ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    private fun reqPermissions(){
        var permissionToRequest = mutableListOf<String>()

        if(!hasLocationForegroundPermission()){
            permissionToRequest.add(android.Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if(!hasLocationBackgroundPermission()){
            permissionToRequest.add(android.Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }

        if (permissionToRequest.isNotEmpty()){
            Log.d("PermissionLog","Udah req Lhoo ${permissionToRequest[1]}")
            ActivityCompat.requestPermissions(this,permissionToRequest.toTypedArray(), 0)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 0 && grantResults.isNotEmpty()){
            for(i in grantResults.indices){
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PermissionLog", "$i Permission ${grantResults[i]} Granted")
                }
                else{
                    Log.d("PermissionLog", "$i Permission ${grantResults[i]} Rejected")
                }
            }
        }
    }

}