package com.example.myapplication

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToast : Button = findViewById(R.id.btnToast)
        val btnSnackBar : Button = findViewById(R.id.btnSnackBar)
        val btnAlertDialog : Button = findViewById(R.id.btnAlertDialog)
        val btnCustom : Button = findViewById(R.id.btnCustomDialog)

        btnToast.setOnClickListener {
            Toast.makeText(this, "Ini toast" , Toast.LENGTH_LONG).show()
            Log.d("Toast","ToastnyaGaMuncul?")
        }
        btnSnackBar.setOnClickListener{
            Snackbar.make(it,"ini Scakbar",Snackbar.LENGTH_SHORT).show()
        }

        btnAlertDialog.setOnClickListener {
            val AlertObj = AlertDialog.Builder(this)
            AlertObj.setPositiveButton("Yosh") { dialog, which ->
                Toast.makeText(applicationContext,"OK Dipicit",Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
            AlertObj.setNegativeButton("Cancel") {dialog,which ->
                Toast.makeText(applicationContext, "cancel terpicit", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            AlertObj
                .setTitle("Message")
                .setMessage("Message Alert Dialog")
            AlertObj.create().show()
        }

        btnCustom.setOnClickListener {
            val Dialog = Dialog(this)
            Dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            Dialog.setCancelable(false)
            Dialog.setContentView(R.layout.custom_dialog)

            val btnCancel : Button = Dialog.findViewById(R.id.btnCancel)
            val btnSubmit : Button = Dialog.findViewById(R.id.btnSubmit)

            btnCancel.setOnClickListener {
                Toast.makeText(this@MainActivity,"klik Cancel",Toast.LENGTH_LONG).show()
                Dialog.dismiss()
            }
            btnSubmit.setOnClickListener {
                Toast.makeText(this@MainActivity,"Sabmit",Toast.LENGTH_LONG).show()
                Dialog.dismiss()
            }
            Dialog.show()

        }

    }
}