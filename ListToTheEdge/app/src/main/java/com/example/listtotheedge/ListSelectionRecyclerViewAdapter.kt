package com.example.listtotheedge;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

val listTitles = arrayOf("Shoppiong","DUGONG","MUlu")

class ListSelectionRecyclerViewAdapter(private val lists:ArrayList<TaskList>) : RecyclerView.Adapter<ListSelectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_selection_view_holder,parent,false)

        return ListSelectionViewHolder(view)
    }
    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        holder.listposition.text = (position+1).toString()
        holder.listTitle.text = lists.get(position).name

    }

}