package com.codingstuff.loginandsignup

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.databinding.ActivityEventsListItemBinding

class EventAdapter(context: Context, private val eventList : ArrayList<EventDataClass>) : RecyclerView.Adapter<EventAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ActivityEventsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = eventList[position]
        with(holder.binding){


        listCategory.text = currentitem.category
        listDate.text = currentitem.date
        listLocation.text = currentitem.location
        listName.text = currentitem.name
        listPrice.text = currentitem.price
        listType.text = currentitem.type
        }
    }

    override fun getItemCount(): Int {

        return eventList.size
    }

    class MyViewHolder(val binding : ActivityEventsListItemBinding)  : RecyclerView.ViewHolder(binding.root){

    }

}