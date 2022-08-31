package com.example.consolatasappartments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var  login:Button
    lateinit var register:Button
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        firebaseAuth=FirebaseAuth.getInstance()

//login.setOnClickListener {
    //checkuser()
//}
        login = findViewById(R.id.mBtnLogin)
        login.setOnClickListener {
            checkuser()
            val intent=Intent(this,Loginform::class.java)
            startActivity(intent) }

            register = findViewById(R.id.mBtnRegister)
        register.setOnClickListener {
            val intent=Intent(this,Registerform::class.java)
            startActivity(intent)
        }


        supportActionBar?.hide()

        

    }

    private fun checkuser() {
        val firebaseUser=firebaseAuth.currentUser
        if(firebaseUser !=null){
            startActivity(Intent(this,MyDashboard::class.java))
            finish()
        }else{
            val intent=Intent(this,Loginform::class.java)
            startActivity(intent)
        }
    }
}