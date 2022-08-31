package com.example.consolatasappartments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.consolatasappartments.databinding.ActivityRegisterformBinding
import com.google.firebase.auth.FirebaseAuth

class Registerform : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegisterformBinding



    lateinit var EnterUserName:EditText
    lateinit var EnterUserEmail:EditText
    lateinit var CreatePassword:EditText
    lateinit var ConfirmPassword:EditText
    lateinit var signin_alt:TextView
    lateinit var register:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registerform)

        supportActionBar?.hide()
binding=ActivityRegisterformBinding.inflate(layoutInflater)
        auth= FirebaseAuth.getInstance()

        CreatePassword=findViewById(R.id.mBtnCreatepass)
        ConfirmPassword=findViewById(R.id.mBtnConfirmpass)
        EnterUserEmail=findViewById(R.id.mBtnEmail)
        EnterUserName=findViewById(R.id.mBtnUserName)

       // register.setOnClickListener {
          //  Signupuser()
       // }

        signin_alt = findViewById(R.id.mBtnAlready)
        signin_alt.setOnClickListener {
            val intent = Intent(this, Loginform::class.java)
            startActivity(intent)
        }

        register = findViewById(R.id.mBtnLogout)
        register.setOnClickListener {
            Signupuser()
            val intent= Intent(this,HomePage::class.java)
            startActivity(intent)
            }

    }
    //signupArea

    private fun Signupuser() {
        val email=EnterUserEmail.text.toString().trim()
        val pass=CreatePassword.text.toString()
        val confirmpassword=ConfirmPassword.text.toString().trim()
        val username=EnterUserName.text.toString().trim()

        //check password

        if (username.isEmpty()){
            EnterUserName.error = "please fill this space!!"
            EnterUserName.requestFocus()
            val intent=Intent(this, Registerform::class.java)
             startActivity(intent)

        }else if (email.isEmpty()){
           EnterUserEmail.error="please fill this space"
            EnterUserEmail.requestFocus()
            val intent=Intent(this, Registerform::class.java)
            startActivity(intent)
            }else if (pass.isEmpty()){
                CreatePassword.error="please fill this space"
            CreatePassword.requestFocus()
            val intent=Intent(this, Registerform::class.java)
            startActivity(intent)
        }else if (confirmpassword.isEmpty()){
            ConfirmPassword.error="please fill this field"
            ConfirmPassword.requestFocus()
            val intent=Intent(this, Registerform::class.java)
            startActivity(intent)
        }

       // if (email.isBlank()||pass.isBlank()||confirmpassword.isBlank()){
           // EnterUserEmail.error="Enter Your Email please"
           // CreatePassword.error="enter Password"
          //  Toast.makeText(this,"this field must be filled",Toast.LENGTH_SHORT).show()

        //}
        ///if (pass != confirmpassword){
            //Toast.makeText(this,"confirm password to proceed",Toast.LENGTH_SHORT).show()
            //return
       // }
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this,"user registered successfully",Toast.LENGTH_SHORT).show()
                finish()

                //val intent=Intent(this, HomePage::class.java)
               // startActivity(intent)
            }else{

                Toast.makeText(this,"Registration Failed",Toast.LENGTH_SHORT).show()
            }

        }
    }

}

