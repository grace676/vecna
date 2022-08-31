package com.example.consolatasappartments

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth

class Mypayment : AppCompatActivity() {

     lateinit var call: TextView
    private lateinit var acquire: Button

    //Firebase
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypayment)

        supportActionBar?.hide()

        call=findViewById(R.id.mBtncall)
        acquire=findViewById(R.id.mBtnHousing)

        //set to access MPESA
        acquire.setOnClickListener {

            val simToolKitLaunchIntent=applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }

        //set for calls
        call .setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0757792010"))
            if (ContextCompat.checkSelfPermission(
                    this@Mypayment,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@Mypayment,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)

                firebaseAuth = FirebaseAuth.getInstance()
    }
}}}