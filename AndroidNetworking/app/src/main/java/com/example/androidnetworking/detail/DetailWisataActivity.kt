package com.example.androidnetworking.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.androidnetworking.R
import org.w3c.dom.Text

class DetailWisataActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_detail_activity)

        val jdDetail : TextView = findViewById(R.id.tvJudulWisata)
        val descDetail : TextView = findViewById(R.id.tvDetailWisita)
        val imgDetail : ImageView = findViewById(R.id.ivPictWisata)
        val nama : String ? = intent.getStringExtra("EXTRA_JUDUL")
        val desk : String ? = intent.getStringExtra("EXTRA_DESK")
        val img : String ? = intent.getStringExtra("EXTRA_IMG")

        jdDetail.text = nama
        descDetail.text=desk
        Glide.with(this@DetailWisataActivity).load(img).into(imgDetail)


    }

}