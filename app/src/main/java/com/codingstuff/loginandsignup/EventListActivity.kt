package com.codingstuff.loginandsignup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingstuff.loginandsignup.databinding.ActivityEventsMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class EventListActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var eventsAdapter : EventAdapter
    private lateinit var eventArrayList: ArrayList<EventDataClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEventsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listOfEvents.layoutManager = LinearLayoutManager(this)
        binding.listOfEvents.setHasFixedSize(true)

        eventsAdapter = EventAdapter(baseContext, eventArrayList)
        binding.listOfEvents.adapter = eventsAdapter
        getEventData()
    }

    private fun getEventData(){
        dbref = Firebase.database.getReference("events")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot){
                if(snapshot.exists()){
                    for(eventSnapshot in snapshot.children){
                        val events = eventSnapshot.getValue(EventDataClass::class.java)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }
}