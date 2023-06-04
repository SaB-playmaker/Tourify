package com.codingstuff.loginandsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.widget.Button
import android.widget.TextView
import android.widget.Toast




class TourAddActivity : AppCompatActivity () {
    private lateinit var txtNewTaskDesc: TextView
    lateinit var _db: DatabaseReference
    private lateinit var btnAdd: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addtour)
        _db = FirebaseDatabase.getInstance().reference
        btnAdd.setOnClickListener { view ->
            addTask() }
    }
        fun addTask() {

                //Declare and Initialise the Task
                val task = Task.create()

                //Set Task Description and isDone Status
                task.taskDesc = txtNewTaskDesc.text.toString()
                task.done = false

                //Get the object id for the new task from the Firebase Database
                val newTask = _db.child(Statics.FIREBASE_TASK).push()
                task.objectId = newTask.key

                //Set the values for new task in the firebase using the footer form
                newTask.setValue(task)


                //Reset the new task description field for reuse.
                txtNewTaskDesc.setText("")

                Toast.makeText(
                    this,
                    "Task added to the list successfully" + task.objectId,
                    Toast.LENGTH_SHORT
                ).show()
            }

        }




