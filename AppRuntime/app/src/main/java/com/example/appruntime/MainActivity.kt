package com.example.appruntime

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

var FINE_LOCATION_REQ = 100
var CAMERA_REQ = 101
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonTaps()
    }

    private fun buttonTaps(){
        val btn_campermission : Button = findViewById<Button>(R.id.btn_camPermission)
        val btn_locPermission : Button = findViewById(R.id.btn_locPermission)
        btn_campermission.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0:View?) : Unit{
                checkForPermission(android.Manifest.permission.CAMERA, "camera", CAMERA_REQ)
            }
        })
        btn_locPermission.setOnClickListener() {
            checkForPermission(android.Manifest.permission.ACCESS_FINE_LOCATION,"location",
                FINE_LOCATION_REQ)
        }
    }

    private fun checkForPermission(permission: String, name : String, requestCode:Int){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Log.d("Permission","MasukPermissionChcek")
            when{
                ContextCompat.checkSelfPermission(applicationContext,permission)== PackageManager.PERMISSION_GRANTED ->{
                    Toast.makeText(applicationContext, "$name granted",Toast.LENGTH_SHORT).show()
                }
                shouldShowRequestPermissionRationale(permission) -> showDialog(permission,name, requestCode)

                else -> {

                    ActivityCompat.requestPermissions(this,arrayOf(permission),requestCode)

                    Log.d("Permission","masuk kok ke ActivityCompat")
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
    fun innerCheck(name: String){
        if(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(applicationContext, "$name permission refused" , Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(applicationContext, "$name permission granted", Toast.LENGTH_LONG).show()
        }
    }
        when (requestCode) {
            FINE_LOCATION_REQ -> innerCheck("location")
            CAMERA_REQ -> innerCheck("Camera")
        }
    }
    private fun showDialog(permission:String, name:String,requestCode:Int){
        val builder = AlertDialog.Builder(this)
        builder.apply{
            setMessage("Permission to access your $name is required to use this app")
            setTitle("Permission Required")
            setPositiveButton("OK") {_,_->
                ActivityCompat.requestPermissions(this@MainActivity, arrayOf(name),requestCode)
            }
        }
        val dialog = builder.create()
        dialog.show()


    }
}