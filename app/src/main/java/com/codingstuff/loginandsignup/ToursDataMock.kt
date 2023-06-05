package com.codingstuff.loginandsignup

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.codingstuff.loginandsignup.databinding.ActivityToursListBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ToursDataMock : AppCompatActivity() {

    private lateinit var binding: ActivityToursListBinding
    private lateinit var toursAdapter: ToursAdapter
    var dataArrayList = ArrayList<ToursData>()
    private lateinit var databaseReference: DatabaseReference
    private val databaseUrl = "https://tourify-76846-default-rtdb.europe-west1.firebasedatabase.app"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToursListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Set up Firebase Database
        databaseReference = FirebaseDatabase.getInstance(databaseUrl).getReference("tours")

        // Load data from Firebase
        loadToursList()
        toursAdapter = ToursAdapter(baseContext, dataArrayList)
        binding.listOfTours.adapter = toursAdapter
    }
    private fun loadToursList() {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    dataArrayList.clear()
                    for (tourSnapshot in dataSnapshot.children) {
                        val tour = tourSnapshot.getValue(ToursData::class.java)
                        if (tour != null) {
                            dataArrayList.add(tour)
                        }
                    }
                    toursAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("ToursDataMock", "loadTour:onCancelled", databaseError.toException())
            }
        })
    }
}