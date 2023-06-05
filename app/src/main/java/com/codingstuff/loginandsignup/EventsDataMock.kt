package com.codingstuff.loginandsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.codingstuff.loginandsignup.databinding.ActivityEventsMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EventsDataMock : AppCompatActivity() {

    private lateinit var binding: ActivityEventsMainBinding
    private lateinit var eventsAdapter: EventsAdapter
    var dataArrayList = ArrayList<Event>()
    private lateinit var databaseReference: DatabaseReference
    private val databaseUrl = "https://tourify-76846-default-rtdb.europe-west1.firebasedatabase.app"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Set up Firebase Database
        databaseReference = FirebaseDatabase.getInstance(databaseUrl).getReference("events")

        // Load data from Firebase
        loadEventsList()
        eventsAdapter = EventsAdapter(baseContext, dataArrayList)
        binding.listOfEvents.adapter = eventsAdapter
    }
    private fun loadEventsList() {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    dataArrayList.clear()
                    for (eventSnapshot in dataSnapshot.children) {
                        val event = eventSnapshot.getValue(Event::class.java)
                        if (event != null) {
                            dataArrayList.add(event)
                        }
                    }
                    eventsAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("EventsDataMock", "loadEvent:onCancelled", databaseError.toException())
            }
        })
    }
}