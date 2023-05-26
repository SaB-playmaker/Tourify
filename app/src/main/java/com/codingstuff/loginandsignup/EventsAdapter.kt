package com.codingstuff.loginandsignup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.codingstuff.loginandsignup.databinding.EventsListBinding

class EventsAdapter(context: Context, dataArrayList: ArrayList<EventData>):
ArrayAdapter<EventData>(context, R.layout.events_list, dataArrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val listData = getItem(position)!!

        if(view == null){
            val binding = EventsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            view = binding.root
            view.tag = binding
        }

        val binding = view.tag as EventsListBinding
        with(binding) {
            listData.image?.let { picture.setImageBitmap(it) }
            listName.text = listData.name
            listType.text = listData.type
            listLocation.text = listData.location
            listPrice.text = listData.price
            listDate.text = listData.date
            listMark.text = listData.optionalText
        }
        return view




    }
}