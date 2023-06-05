package com.codingstuff.loginandsignup;


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingstuff.loginandsignup.databinding.ActivityEventsMainBinding

public class EventActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityEventsMainBinding
    private lateinit var eventsAdapter: EventsAdapter
    var dataArrayList = ArrayList<EventPageData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataArrayList.add(EventPageData("OkeanElzy", "concert","Chernivtsi", "from 450 UAH", "29 May","Popular Event",null))
        dataArrayList.add(EventPageData("WorldFoodUkraine", "fair","Kyiv", "100-200 UAH", "1-3 Nov","Popular Event",null))
        dataArrayList.add(EventPageData("Atlas Weekend", "concert","Kyiv", "from 600 UAH", "7-10 Jul","Popular Event",null))

        eventsAdapter = EventsAdapter(this, dataArrayList)
        binding.listOfEvents.adapter = eventsAdapter

    }
}
