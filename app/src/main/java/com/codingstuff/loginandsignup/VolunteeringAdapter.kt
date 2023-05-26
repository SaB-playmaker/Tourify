package com.codingstuff.loginandsignup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.codingstuff.loginandsignup.databinding.EventsListBinding

class VolunteeringAdapter(context: Context, dataArrayList: ArrayList<VolunteeringData>):
    ArrayAdapter<VolunteeringData>(context, R.layout.events_list, dataArrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val listData = getItem(position)!!

        if(view == null){
            val binding =EventsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            view = binding.root
            view.tag = binding
        }

        val binding = view.tag as EventsListBinding
        with(binding) {
            listData.image?.let { picture.setImageBitmap(it) }
            textView.text = listData.name
            textView2.text = listData.goal
            textView3.text = listData.location
        }
        return view

    }
}