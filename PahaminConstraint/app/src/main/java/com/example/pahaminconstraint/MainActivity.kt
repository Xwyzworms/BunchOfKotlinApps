package com.example.pahaminconstraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.view.View
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnApply: Button = findViewById<Button>(R.id.btnApply)
        val btnTambah : Button = findViewById<Button>(R.id.btnTambah)
        var counter = 0
        btnApply.setOnClickListener{it ->
            // Initiate Variable
            val firstName : String = findViewById<EditText>(R.id.etFirstName).text.toString()
            val lastName : String = findViewById<EditText>(R.id.etLastName).text.toString()
            val birthDate : String = findViewById<EditText>(R.id.etBirthDate).text.toString()
            val ngopi : String = findViewById<EditText>(R.id.etNgopi).text.toString()
            Log.d("MainActivity","papapa $firstName $lastName Birth : $birthDate Jadi ngopi ? $ngopi")
        }
        btnTambah.setOnClickListener{it ->
            counter += 1
            val theText : TextView = findViewById<TextView>(R.id.tvHitung)
            val default : String = getText(R.string.dahlah).toString()
            theText.setText(default + counter)
        }



    }
}