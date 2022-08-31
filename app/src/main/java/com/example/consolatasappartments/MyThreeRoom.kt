package com.example.consolatasappartments


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MyThreeRoom : AppCompatActivity() {
    lateinit var acquire: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_three_room)
        supportActionBar?.hide()
        acquire = findViewById(R.id.mBtnHousing)
        acquire.setOnClickListener {
            val intent= Intent(this,Mypayment::class.java)
            startActivity(intent)
            Toast.makeText(this@MyThreeRoom,"pay now!!", Toast.LENGTH_LONG).show()
        }

        }}

