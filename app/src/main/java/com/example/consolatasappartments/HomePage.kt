package com.example.consolatasappartments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class HomePage : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var ViewHouses:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        supportActionBar?.hide()

        //connect to firebase
        auth=FirebaseAuth.getInstance()

       ViewHouses = findViewById(R.id.mBtnViewHouses)
       ViewHouses.setOnClickListener {
            val intent= Intent(this,MyDashboard::class.java)
            startActivity(intent)}

    }
}