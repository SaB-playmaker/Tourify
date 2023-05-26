package com.codingstuff.loginandsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingstuff.loginandsignup.databinding.ActivityMainBinding

class MainActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toursAdapter: ToursAdapter
    var dataArrayList = ArrayList<ToursData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataArrayList.add(ToursData("Тур по Карпатах", "5 days", "Carpathians", "100$", "10 Apr", "Bus"))
        dataArrayList.add(ToursData("Тур до Одеси", "3 days", "Odesa", "200$", "25 June", "Bus"))
        dataArrayList.add(ToursData("Тур до Чернівців", "2 days", "Chernivtsi", "150$", "3 Aug", "Train"))
        toursAdapter = ToursAdapter(baseContext, dataArrayList)
        binding.listOfTours.adapter = toursAdapter
    }
}