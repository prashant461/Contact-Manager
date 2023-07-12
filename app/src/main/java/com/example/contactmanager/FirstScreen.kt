package com.example.contactmanager

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FirstScreen : AppCompatActivity() {
    lateinit var dilog:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)
        val saveContact = findViewById<Button>(R.id.btnSaveContact)

        // initializing the late inite variable
        dilog = Dialog(this)
        dilog.setContentView(R.layout.savealert)
        val ok = dilog.findViewById<Button>(R.id.btnOkalert)
        ok.setOnClickListener {
            dilog.dismiss()
        }
        saveContact.setOnClickListener {
            dilog.show();
        }
    }
}