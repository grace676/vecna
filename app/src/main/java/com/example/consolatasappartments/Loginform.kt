package com.example.consolatasappartments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Loginform : AppCompatActivity() {

    lateinit var EnterUserName: EditText
    lateinit var EnterPassword: EditText
    lateinit var signup:Button
    lateinit var signup_alt: TextView

    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginform)

        supportActionBar?.hide()

        EnterPassword = findViewById(R.id.mBtnpass)
        signup_alt = findViewById(R.id.textView6)
        EnterUserName = findViewById(R.id.mBtnUser)


        firebaseAuth=FirebaseAuth.getInstance()

        //initializing auth object

//signup.setOnClickListener {
   // login()

//}

        signup_alt.setOnClickListener {
            val intent = Intent(this, Registerform::class.java)
            startActivity(intent)
        }

        signup = findViewById(R.id.mBtnLogin)
        signup.setOnClickListener {
            login()
            val intent= Intent(this,HomePage::class.java)
            startActivity(intent)
        }

    }

    private fun login() {
        val username=EnterUserName.text.toString()
        val pass=EnterPassword.text.toString()


        if (username.isEmpty()){
            EnterUserName.error = "please fill this space!!"
            EnterUserName.requestFocus()
            val intent=Intent(this, Loginform::class.java)
            startActivity(intent)}
    else if (pass.isEmpty()){
        EnterPassword.error="please fill this space"
        EnterPassword.requestFocus()
        val intent=Intent(this, Loginform::class.java)
        startActivity(intent)}
        //calling signin with email and pass
        //function using firebase auth
        //on successful response display a toast
        firebaseAuth.signInWithEmailAndPassword(username,pass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this,"login successful",Toast.LENGTH_LONG).show()
            }else{


                Toast.makeText(this,"log in failed ",Toast.LENGTH_LONG).show()
            }
        }
    }

}
