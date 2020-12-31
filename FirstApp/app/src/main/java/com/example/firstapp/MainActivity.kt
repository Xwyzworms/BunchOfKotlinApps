package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun ConvertTheInput(view :View)
    {
        if(AmountInput.text.isNotEmpty()){
                val dollarValue = AmountInput.text.toString().toFloat()
                val converted = dollarValue * 0.85
            textView.text = converted.toString()
        }else{
            textView.text=getString(R.string.HelloApplication)
        }



    }
}