package com.example.assignment_4

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_4.databinding.ItemContactBinding

class Adapter(val list : List<Contact>,var OnClick : (contact: Contact,index:Int)->Unit) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class ViewHolder(var itemview: ItemContactBinding) : RecyclerView.ViewHolder(itemview.root){



    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var Binding = ItemContactBinding.inflate(inflater)
        return ViewHolder(Binding)

    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder as ViewHolder){
        with(list[position]) {
            holder.itemview.tvName.text = name
            holder.itemview.phone.text = phone.toString()
            holder.itemView.setOnClickListener {
                OnClick.invoke(list[position],position)

            }

    }
        }
}
}