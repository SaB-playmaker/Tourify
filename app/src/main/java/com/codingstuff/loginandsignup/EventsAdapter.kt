package com.codingstuff.loginandsignup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.codingstuff.loginandsignup.databinding.ActivityEventsListItemBinding

class EventsAdapter(context: Context,private val dataArrayList: ArrayList<EventPageData>):
    ArrayAdapter<EventPageData>(context, R.layout.activity_events_list_item, dataArrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val listData = getItem(position)!!

        if(view == null){
            val binding = ActivityEventsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            view = binding.root
            view.tag = binding
        }

        val binding = view.tag as ActivityEventsListItemBinding
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