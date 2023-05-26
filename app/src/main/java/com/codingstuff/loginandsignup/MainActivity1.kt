package com.codingstuff.loginandsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingstuff.loginandsignup.databinding.ActivityMainBinding

class MainActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var eventsAdapter: VolunteeringAdapter
    var dataArrayList = ArrayList<VolunteeringData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataArrayList.add(VolunteeringData("ДоБроБат", "Fast Recovery","    Ukraine"))
        dataArrayList.add(VolunteeringData("Repair Together", "Help Victims","Ukraine"))
        dataArrayList.add(VolunteeringData("Сміливі відновлювати", "Відновлення будинків","Ukraine"))
        eventsAdapter = VolunteeringAdapter(baseContext, dataArrayList)
        binding.listOfEvents.adapter = eventsAdapter
    }
}