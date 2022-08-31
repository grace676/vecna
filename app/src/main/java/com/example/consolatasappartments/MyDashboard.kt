package com.example.consolatasappartments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MyDashboard : AppCompatActivity() {
    lateinit var singlebedroom:ImageView
    lateinit var onebedroom:ImageView
    lateinit var twobedroom:ImageView
    lateinit var threebedroom:ImageView
    lateinit var logout: Button

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_dashboard)

        supportActionBar?.hide()
        logout = findViewById(R.id.MbtnLogout)
        logout.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

        //connecting to the firebase
        auth= FirebaseAuth.getInstance()


        //setting ONCLICK listeners to the images

        singlebedroom = findViewById(R.id.image1)
        singlebedroom.setOnClickListener {
            val intent= Intent(this,MySingleRoom::class.java)
            startActivity(intent)
            Toast.makeText(this@MyDashboard,"welcome to our apartments", Toast.LENGTH_LONG).show()}

        onebedroom = findViewById(R.id.image2)
        onebedroom.setOnClickListener {
            val intent= Intent(this,MyOneRoom::class.java)
            startActivity(intent)
            Toast.makeText(this@MyDashboard,"welcome to our apartments", Toast.LENGTH_LONG).show()}

        twobedroom = findViewById(R.id.image3)
        twobedroom.setOnClickListener {
            val intent= Intent(this,MyTwoRoom::class.java)
            startActivity(intent)
            Toast.makeText(this@MyDashboard,"welcome to our apartments", Toast.LENGTH_LONG).show()}

        threebedroom = findViewById(R.id.image4)
        threebedroom.setOnClickListener {
            val intent= Intent(this,MyThreeRoom::class.java)
            startActivity(intent)
            Toast.makeText(this@MyDashboard,"welcome to our apartments", Toast.LENGTH_LONG).show()}
    }
}