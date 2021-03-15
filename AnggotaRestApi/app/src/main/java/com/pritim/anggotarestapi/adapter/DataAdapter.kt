package com.pritim.anggotarestapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pritim.anggotarestapi.Model.getdata.DataItem
import com.pritim.anggotarestapi.R

class DataAdapter(val data : List<DataItem>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val activity = LayoutInflater.from(parent.context).inflate(R.layout.recycler_content,parent,false)

        return ViewHolder(activity)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item  = data.get(position)

        holder.nama.text = item.nama
        holder.nohp.text = item.nohp
        holder.alamat.text = item.alamat

    }

    override fun getItemCount(): Int {

        return data?.size ?: 0
    }


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
         val nama : TextView = itemView.findViewById(R.id.tvNama)
         val nohp : TextView = itemView.findViewById(R.id.tvNohp)
         val alamat : TextView = itemView.findViewById(R.id.tvAlamat)

    }

}