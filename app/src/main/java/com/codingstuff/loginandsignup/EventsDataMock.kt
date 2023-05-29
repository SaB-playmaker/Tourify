package com.codingstuff.loginandsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingstuff.loginandsignup.databinding.ActivityEventsMainBinding

class EventsDataMock : AppCompatActivity() {

    private lateinit var binding: ActivityEventsMainBinding
    private lateinit var eventsAdapter: EventsAdapter
    var dataArrayList = ArrayList<EventData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataArrayList.add(EventData("OkeanElzy", "concert","Chernivtsi", "from 450 UAH", "29 May","Popular Event"))
        dataArrayList.add(EventData("WorldFoodUkraine", "fair","Kyiv", "100-200 UAH", "1-3 Nov","Popular Event"))
        dataArrayList.add(EventData("Atlas Weekend", "concert","Kyiv", "from 600 UAH", "7-10 Jul","Popular Event"))
        eventsAdapter = EventsAdapter(baseContext, dataArrayList)
        binding.listOfEvents.adapter = eventsAdapter
    }
}