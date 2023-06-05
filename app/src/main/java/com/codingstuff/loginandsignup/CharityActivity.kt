package com.codingstuff.loginandsignup

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.codingstuff.loginandsignup.databinding.ActivityCharityListBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CharityActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharityListBinding
    private lateinit var volunteeringAdapter: VolunteeringAdapter
    var dataArrayList = ArrayList<VolunteeringData>()
    private lateinit var databaseReference: DatabaseReference
    private val databaseUrl = "https://tourify-76846-default-rtdb.europe-west1.firebasedatabase.app"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Set up Firebase Database
        databaseReference = FirebaseDatabase.getInstance(databaseUrl).getReference("charity")

        // Load data from Firebase
        loadToursList()
        volunteeringAdapter = VolunteeringAdapter(baseContext, dataArrayList)
        binding.listOfEvents.adapter = volunteeringAdapter
    }
    private fun loadToursList() {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    dataArrayList.clear()
                    for (tourSnapshot in dataSnapshot.children) {
                        val charity = tourSnapshot.getValue(VolunteeringData::class.java)
                        if (charity != null) {
                            dataArrayList.add(charity)
                        }
                    }
                    volunteeringAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("ToursDataMock", "loadTour:onCancelled", databaseError.toException())
            }
        })
    }
}