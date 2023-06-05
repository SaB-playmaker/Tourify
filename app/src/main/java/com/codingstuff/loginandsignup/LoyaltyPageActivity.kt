package com.codingstuff.loginandsignup

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LoyaltyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loyalty_page) // use your layout file here
    }

    fun bankButtonOnClickMethod(view: View) {
        val intent = Intent(this, LoyaltyBankActivity::class.java)
        startActivity(intent)
    }
    fun addOnClickMethod(view: View) {
        val intent = Intent(this, AddEventActivity::class.java)
        startActivity(intent)
    }
}
