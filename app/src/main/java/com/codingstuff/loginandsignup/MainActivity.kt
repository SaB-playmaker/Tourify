package com.codingstuff.loginandsignup

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun myOnClickMethod(view: View) {
        val intent = Intent(this, ToursDataMock::class.java)
        startActivity(intent)
    }

}
