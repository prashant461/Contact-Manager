package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val mail=findViewById<TextInputEditText>(R.id.signInMail)
        val mobile=findViewById<TextInputEditText>(R.id.signInMobile)




        val signIn = findViewById<Button>(R.id.btnSignIn)
        signIn.setOnClickListener {
            val dmobile=mobile.text.toString()
            if(dmobile.isNotEmpty()){
                readData(dmobile)
            }
            else{
                Toast.makeText(this,"Please enter your Mobile number!!",Toast.LENGTH_SHORT).show()
            }

        }

    }
    private fun readData(mobile: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("User")

        databaseReference.child(mobile).get().addOnSuccessListener {
            if(it.exists()){
                intent= Intent(this,FirstScreen::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"User Not Exists...", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"Failed...", Toast.LENGTH_SHORT)
        }
    }
}