package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class SignUpActivity : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val name=findViewById<TextInputEditText>(R.id.signUpName)
        val mail=findViewById<TextInputEditText>(R.id.signUpMail)
        val password=findViewById<TextInputEditText>(R.id.signUpPassword)
        val mobile=findViewById<TextInputEditText>(R.id.signUpMobile)
        val signUp=findViewById<Button>(R.id.btnSignUp)


        signUp.setOnClickListener {
            val dname=name.text.toString()
            val dmail=mail.text.toString()
            val dpass=password.text.toString()
            val dmobile=mobile.text.toString()
            val user = User(dname,dmail,dpass,dmobile)

            databaseReference=FirebaseDatabase.getInstance().getReference("User")

            databaseReference.child(dmobile).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"Sign Up completed...\nPlease login to continue...",Toast.LENGTH_SHORT).show()
                intent=Intent(this,SignInActivity::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this,"We are sorry to register you!!..\nPlease try later...",Toast.LENGTH_SHORT).show()
            }


        }

        // if user is already registered
        val signIn = findViewById<TextView>(R.id.tVSignIn)
        signIn.setOnClickListener {
            intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }
    }
}