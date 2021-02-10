package com.example.pahaminconstraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import org.w3c.dom.Text
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnApply: Button = findViewById<Button>(R.id.btnApply)
        val btnTambah : Button = findViewById<Button>(R.id.btnTambah)
        val btnAdd : Button = findViewById<Button>(R.id.btnAdd)
        val btnGambar : Button = findViewById<Button>(R.id.btnGambar)
        val btnOrder : Button = findViewById<Button>(R.id.btnOrder)
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
            theText.text = default + counter        }
        btnAdd.setOnClickListener{it->
            var num1 : Int = findViewById<EditText>(R.id.etFirstNum).text.toString().toInt()
            var num2 : Int = findViewById<EditText>(R.id.etSecNum).text.toString().toInt()

            var ans : Int = num1 + num2
            val tvHasil : TextView = findViewById<TextView>(R.id.tvHasil)
            Log.d("MainActivity","KEbentuk?")
            tvHasil.text = ans.toString()

        }

        btnGambar.setOnClickListener(View.OnClickListener(){
          val tvImage :ImageView = findViewById(R.id.imvGithub)
          tvImage.setImageResource(R.drawable.github)
        })

        btnOrder.setOnClickListener(View.OnClickListener {
            val RadQuest : RadioGroup = findViewById<RadioGroup>(R.id.rgQuest)
            val checkedRadGroup : Int = RadQuest.checkedRadioButtonId
            val RadButton : RadioButton = findViewById<RadioButton>(checkedRadGroup)
            val isGojChecked : Boolean = findViewById<CheckBox>(R.id.cbgojay).isChecked
            val isSimChecked : Boolean = findViewById<CheckBox>(R.id.cbsimon).isChecked
            val isGratisChecked: Boolean = findViewById<CheckBox>(R.id.cbGratis).isChecked

            val OrderedString : String = "Hello today you order :\n"+
                    "${RadButton.text}\n" +
                    (if (isGojChecked) "Gojay\n" else "")+
                    (if(isSimChecked)"Simon Viklund\n" else "")+
                    (if(isGratisChecked) "Gratis Boy\n" else "")
            val TvOrder : TextView = findViewById<TextView>(R.id.tvListPesanan)
            TvOrder.text = OrderedString
        })


    }
}