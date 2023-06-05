package com.codingstuff.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codingstuff.loginandsignup.databinding.ActivityEventsMainBinding

class EventsDataMock : AppCompatActivity() {

    private lateinit var binding: ActivityEventsMainBinding
    private lateinit var eventsAdapter: EventsAdapter
    var dataArrayList = ArrayList<EventPageData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataArrayList.add(
            EventPageData(
                "OkeanElzy",
                "concert",
                "Chernivtsi",
                "from 450 UAH",
                "29 May",
                "Popular Event"
            )
        )
        dataArrayList.add(
            EventPageData(
                "WorldFoodUkraine",
                "fair",
                "Kyiv",
                "100-200 UAH",
                "1-3 Nov",
                "Popular Event"
            )
        )
        dataArrayList.add(
            EventPageData(
                "Atlas Weekend",
                "concert",
                "Kyiv",
                "from 600 UAH",
                "7-10 Jul",
                "Popular Event"
            )
        )
        eventsAdapter = EventsAdapter(baseContext, dataArrayList)
        binding.listOfEvents.adapter = eventsAdapter

        binding.listOfEvents.setOnItemClickListener { parent, view, pos, id ->
            val intent = Intent(this, EventActivity::class.java)
            startActivity(intent)
        }
    }
}




