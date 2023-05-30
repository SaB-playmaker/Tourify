package com.codingstuff.loginandsignup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.codingstuff.loginandsignup.databinding.ToursPageBinding

class ToursAdapter(context: Context,dataArrayList: ArrayList<ToursData>):
ArrayAdapter<ToursData>(context, R.layout.tours_page, dataArrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
         var view = convertView
         val listData = getItem(position)!!

         if (view == null){
             val binding = ToursPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
             view = binding.root
             view.tag = binding
         }
        val binding = view.tag as ToursPageBinding
        with(binding) {
            listData.image?.let { picture.setImageBitmap(it) }
            listName.text = listData.name
            listDuration.text = listData.duration
            listLocation.text = listData.location
            listPrice.text = listData.price
            listDate.text = listData.date
            listTransport.text = listData.transport
        }
        return view
    }
}