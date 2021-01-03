package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var isnewOP = true
    var thedot = false
    fun BUDotEvent(view:View){
        print("Lol")
    }
    fun BUResultEvent(view:View){
        print("yow")
    }
    fun BUDivEvent(view:View){
        print("los")
    }
    fun BUMinusEvent(view:View){
        print("dol")
    }
    fun BUModuloEvent(view:View){
        print("ks")
    }
    fun BUCleanAC(view:View){
        print("sam")
        etShowNumber.setText("")


    }
    fun BUPlusEvent(view:View){
        print("Gdsa")
    }
    fun BuOperatorEvent(view:View){
        print("Das")
    }
    fun BUNumberEvent(view:View){
        if (isnewOP){
            etShowNumber.setText("")
        }
        isnewOP = false
        val buSelect = view as Button
        var buClickValue:String = etShowNumber.text.toString()

        when(buSelect.id){
            BUOne.id->{
                buClickValue+="1"
            }
            BUTwo.id->{
                buClickValue+="2"
            }
            BUThree.id->{
                buClickValue+='3'
            }
            BUFour.id->{
                buClickValue+='4'
            }
            BUFive.id->{
                buClickValue+="5"
            }
            BUSix.id-> {
                buClickValue += "6"
            }
            BUSeven.id->{
                buClickValue +='7'
            }
            BU8.id->{
                buClickValue +='8'
            }
            BU9.id->{
                buClickValue +="9"
            }
            BUZero.id->{
                buClickValue += '0'
            }
            BUPlusMinus.id->{
                buClickValue="-" + buClickValue

            }
            BUDot.id->{
                if(!thedot) {
                    buClickValue += "."
                }
                thedot = true
            }
        }
        etShowNumber.setText(buClickValue)



    }
}