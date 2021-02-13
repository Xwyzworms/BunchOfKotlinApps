package com.example.intentions

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val tvManusia : TextView = findViewById<TextView>(R.id.tvResult)
        val manusia = intent.getSerializableExtra("EXTRA_MANUSIA") as Manusia
        val personString = "${manusia.name} dengan umur : ${manusia.umur} hidup di kota :${manusia.kota}"

        tvManusia.text = personString
    }
}