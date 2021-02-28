package com.example.androidnetworking.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidnetworking.R
import com.example.androidnetworking.detail.DetailWisataActivity
import com.example.androidnetworking.model.Wisata

class WisataAdapter(var data: Array<Wisata>?) : RecyclerView.Adapter<WisataAdapter.WisataHolder>(){
    class WisataHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val img  : ImageView =itemView.findViewById<ImageView>(R.id.ivPict)
        val namaDaerah : TextView = itemView.findViewById<TextView>(R.id.tvShowInfoDaerah)
        val nama : TextView = itemView.findViewById<TextView>(R.id.tvShowNama)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataHolder {
            val viewgan  = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata,parent,false)
            return WisataHolder(viewgan)
    }

    override fun onBindViewHolder(holder: WisataHolder, position: Int) {
        holder.nama.text = data?.get(position)?.nama_tempat
        holder.namaDaerah.text = data?.get(position)?.lokasi
        Glide.with(holder.itemView.context).load(data?.get(position)?.gambar).into(holder.img)
        holder.itemView.setOnClickListener{
        val intent = Intent(holder.itemView.context,DetailWisataActivity::class.java)
        intent.putExtra("EXTRA_JUDUL",data?.get(position)?.nama_tempat)
        intent.putExtra("EXTRA_DESK",data?.get(position)?.deskripsi)
        intent.putExtra("EXTRA_IMG",data?.get(position)?.gambar)
        holder.itemView.context.startActivity(intent)
    }
    }

    override fun getItemCount(): Int {

        return data?.size ?: 0
    }
}