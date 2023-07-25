package com.example.a623

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a623.databinding.ItemViewBinding

class RvAdapter(var contactlist:ArrayList<Contact>, var onClik: OnClik): RecyclerView.Adapter<RvAdapter.rvadapterholder>() {
    inner class rvadapterholder(var itemview : ItemViewBinding):RecyclerView.ViewHolder(itemview.root){

        fun onbain(contact:Contact,position: Int){
            itemview.nameItem.text = contact.name
            itemview.btnClick.setOnClickListener {
                onClik.click(contact,position)
            }
//            itemview.image_item.setImageResource(contact.image!!)
//            Picasso.with(context).load(contact.image).into(itemview.image_item)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvadapterholder {
        return rvadapterholder(ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: rvadapterholder, position: Int) {
        var contact =contactlist[position]
        holder.onbain(contact,position)

    }

    override fun getItemCount(): Int {
        return contactlist.size

    }

    interface OnClik{
        fun click(contact: Contact,position: Int){

        }
    }

}