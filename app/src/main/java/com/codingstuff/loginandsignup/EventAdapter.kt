package com.codingstuff.loginandsignup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class EventAdapter(context: Context, eventList: MutableList<Event>) : BaseAdapter() {

    private val _inflater: LayoutInflater = LayoutInflater.from(context)
    private var _eventList = eventList

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val objectId: String = _eventList.get(position).objectId as String
        val desc: String = _eventList.get(position).description as String
        val name: String = _eventList.get(position).name as String
        val price: String = _eventList.get(position).price as String
        val date: String = _eventList.get(position).date as String
        val location: String = _eventList.get(position).location as String
        val type: String = _eventList.get(position).type as String


        val view: View
        val listRowHolder: ListRowHolder
        if (convertView == null) {
            view = _inflater.inflate(R.layout.activity_events_list_item, parent, false)
            listRowHolder = ListRowHolder(view)
            view.tag = listRowHolder
        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }

        listRowHolder.desc.text = desc
        listRowHolder.name.text = name
        listRowHolder.price.text = price
        listRowHolder.date.text = date
        listRowHolder.location.text = location
        listRowHolder.type.text = type

        return view
    }

    override fun getItem(index: Int): Any {
        return _eventList.get(index)
    }

    override fun getItemId(index: Int): Long {
        return index.toLong()
    }

    override fun getCount(): Int {
        return _eventList.size
    }

    private class ListRowHolder(row: View?) {
        val desc: TextView = row!!.findViewById(R.id.description) as TextView
        val name: TextView = row!!.findViewById(R.id.listName) as TextView
        val price: TextView = row!!.findViewById(R.id.price) as TextView
        val date: TextView = row!!.findViewById(R.id.date) as TextView
        val location: TextView = row!!.findViewById(R.id.location) as TextView
        val type: TextView = row!!.findViewById(R.id.type) as TextView
    }
}
