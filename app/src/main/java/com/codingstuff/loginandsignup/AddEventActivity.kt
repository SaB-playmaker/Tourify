package com.codingstuff.loginandsignup

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import java.util.UUID

class AddEventActivity : AppCompatActivity() {

    lateinit var _db: DatabaseReference
    lateinit var _storage: StorageReference
    private val databaseUrl = "https://tourify-76846-default-rtdb.europe-west1.firebasedatabase.app"
    private val storageUrl = "gs://tourify-76846.appspot.com"
    private val PICK_IMAGE_REQUEST = 71
    private var filePath: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtask)

        _db = FirebaseDatabase.getInstance(databaseUrl).reference
        _storage = FirebaseStorage.getInstance(storageUrl).reference

        val btnAdd = findViewById<ImageButton>(R.id.btnAdd)
        val selectImageButton = findViewById<Button>(R.id.selectImageButton)
        val txtNewDesc = findViewById<EditText>(R.id.description)
        val txtName = findViewById<EditText>(R.id.Name)
        val txtPrice = findViewById<EditText>(R.id.price)
        val txtDate = findViewById<EditText>(R.id.date)
        val txtlocation = findViewById<EditText>(R.id.location)
        val txtType = findViewById<EditText>(R.id.type)

        btnAdd.setOnClickListener {
            addEvent(txtNewDesc, txtName, txtPrice, txtDate, txtlocation, txtType)
        }

        selectImageButton.setOnClickListener {
            launchGallery()
        }
    }

    private fun launchGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            filePath = data.data
        }
    }


    fun addEvent(Desc: EditText, Name: EditText, Price: EditText, Date: EditText, Location: EditText, Type: EditText) {
        if (filePath != null) {
            val ref = _storage.child("images/" + UUID.randomUUID().toString())
            val uploadTask = ref.putFile(filePath!!)

            val urlTask = uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
                if (!task.isSuccessful) {
                    task.exception?.let {
                        throw it
                    }
                }
                return@Continuation ref.downloadUrl
            }).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val downloadUri = task.result
                    val event = Event.create()
                    event.description = Desc.text.toString()
                    event.name = Name.text.toString()
                    event.price = Price.text.toString()
                    event.date = Date.text.toString()
                    event.location = Location.text.toString()
                    event.type = Type.text.toString()
                    event.imageURL = downloadUri.toString()  // Set image URL

                    val newTask = _db.child(Statics.FIREBASE_TASK).push()
                    event.objectId = newTask.key

                    newTask.setValue(event)

                    Desc.setText("")
                    Name.setText("")
                    Price.setText("")
                    Date.setText("")
                    Location.setText("")
                    Type.setText("")

                    Toast.makeText(this, "Task added to the list successfully" + event.objectId, Toast.LENGTH_SHORT).show()
                } else {
                    // Handle failures
                    Toast.makeText(this, "Image upload failed: " + task.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

