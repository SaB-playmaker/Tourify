package com.codingstuff.loginandsignup

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddEventActivity : AppCompatActivity() {
    lateinit var _db: DatabaseReference
    private val databaseUrl = "https://tourify-76846-default-rtdb.europe-west1.firebasedatabase.app"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtask)

        _db = FirebaseDatabase.getInstance(databaseUrl).reference

        val btnAdd = findViewById<ImageButton>(R.id.btnAdd)
        val txtNewDesc = findViewById<EditText>(R.id.description)
        val txtName = findViewById<EditText>(R.id.Name)
        val txtPrice = findViewById<EditText>(R.id.price)
        val txtDate = findViewById<EditText>(R.id.date)
        val txtlocation = findViewById<EditText>(R.id.location)
        val txtType = findViewById<EditText>(R.id.type)

        btnAdd.setOnClickListener{ view ->
            addEvent(txtNewDesc, txtName, txtPrice, txtDate, txtlocation, txtType)
        }
    }

    fun addEvent(Desc: EditText, Name: EditText, Price: EditText, Date: EditText, Location: EditText, Type: EditText){
        //Declare and Initialise the Task
        val event = Event.create()
        event.description = Desc.text.toString()
        event.name = Name.text.toString()
        event.price = Price.text.toString()
        event.date = Date.text.toString()
        event.location = Location.text.toString()
        event.type = Type.text.toString()

        //Get the object id for the new task from the Firebase Database
        val newTask = _db.child(Statics.FIREBASE_TASK).push()
        event.objectId = newTask.key

        //Set the values for new task in the firebase using the footer form
        newTask.setValue(event)

        //Reset the new task description field for reuse.
        Desc.setText("")
        Name.setText("")
        Price.setText("")
        Date.setText("")
        Location.setText("")
        Type.setText("")

        Toast.makeText(this, "Task added to the list successfully" + event.objectId, Toast.LENGTH_SHORT).show()
    }

}
