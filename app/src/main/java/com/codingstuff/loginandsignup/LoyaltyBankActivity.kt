package com.codingstuff.loginandsignup

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class LoyaltyBankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loyalty_bank) // use your layout file here
    }
    fun underDevAlertOnClickMethod(view: View) {
        AlertDialog.Builder(this)
            .setTitle("Under development")
            .setMessage("This feature is under development")
            .setPositiveButton("OK", null)
            .show()
    }
}