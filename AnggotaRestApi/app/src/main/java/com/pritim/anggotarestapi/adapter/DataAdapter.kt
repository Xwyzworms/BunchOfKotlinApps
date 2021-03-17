package com.pritim.anggotarestapi.adapter

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pritim.anggotarestapi.Model.getdata.DataItem
import com.pritim.anggotarestapi.R

class DataAdapter(val data : List<DataItem>? , val itemClick : OnClickListener) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.recycler_content,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item  = data?.get(position)

        holder.nama.text = item?.nama
        holder.nohp.text = item?.nohp
        holder.alamat.text = item?.alamat

        holder.view.setOnClickListener {
            itemClick.detail(item)
        }
    }

    override fun getItemCount(): Int {

        return data?.size ?: 0
    }


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
         val nama : TextView = itemView.findViewById(R.id.tvNama)
         val nohp : TextView = itemView.findViewById(R.id.tvNohp)
         val alamat : TextView = itemView.findViewById(R.id.tvAlamat)

    }

    interface OnClickListener {
        fun detail(item : DataItem?)
    }

}