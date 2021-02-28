package com.example.androidnetworking

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen_activity)
        Handler().postDelayed ({
            val intentObj: Intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intentObj)
        },3000)

    }
}