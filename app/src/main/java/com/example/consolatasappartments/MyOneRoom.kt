package com.example.consolatasappartments


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MyOneRoom : AppCompatActivity() {
    lateinit var acquire:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_one_room)

        supportActionBar?.hide()
        acquire = findViewById(R.id.mBtnHousing)
        acquire.setOnClickListener {
            val intent= Intent(this,Mypayment::class.java)
            startActivity(intent)
            Toast.makeText(this@MyOneRoom,"pay now!!", Toast.LENGTH_LONG).show()
        }

        }
        }