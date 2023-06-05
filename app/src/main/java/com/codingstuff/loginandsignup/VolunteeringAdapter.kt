package com.codingstuff.loginandsignup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.codingstuff.loginandsignup.databinding.ActivityCaharityListItemBinding
import com.codingstuff.loginandsignup.databinding.ActivityEventsListItemBinding
import com.squareup.picasso.Picasso

class VolunteeringAdapter(context: Context, dataArrayList: ArrayList<VolunteeringData>):
    ArrayAdapter<VolunteeringData>(context, R.layout.activity_caharity_list_item, dataArrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val listData = getItem(position)!!

        if(view == null){
            val binding = ActivityCaharityListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            view = binding.root
            view.tag = binding
        }

        val binding = view.tag as ActivityCaharityListItemBinding
        with(binding) {

            location.text = listData.location
            name.text = listData.name
            description.text = listData.description

            Picasso.get()
                .load(listData.imageURL)
                .into(picture)
        }
        return view
    }
}