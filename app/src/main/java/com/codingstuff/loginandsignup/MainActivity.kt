package com.codingstuff.loginandsignup

import androidx.appcompat.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun toursOnClickMethod(view: View) {
        val intent = Intent(this, ToursDataMock::class.java)
        startActivity(intent)
    }
    fun eventsOnClickMethod(view: View) {
        val intent = Intent(this, EventsDataMock::class.java)
        startActivity(intent)
    }
    fun underDevAlertOnClickMethod(view: View) {
        AlertDialog.Builder(this)
            .setTitle("Under development")
            .setMessage("This feature is under development")
            .setPositiveButton("OK", null)
            .show()
    }
    fun loyaltyPageOnClickMethod(view: View) {
        val intent = Intent(this, LoyaltyPageActivity::class.java)
        startActivity(intent)
    }

    fun charityOnClickMethod(view: View) {
        val intent = Intent(this, CharityActivity::class.java)
        startActivity(intent)
    }
}
