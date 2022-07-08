package com.example.chatappwithencryption

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class logIn : AppCompatActivity() {

    var TAG:String="LogIn_Activity"

    private lateinit var editemail:EditText
    private lateinit var editpass:EditText
    private lateinit var loginbtn:Button
    private lateinit var signupbtn:Button

    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        supportActionBar?.hide()

        editemail=findViewById(R.id.logIn_email)

        editpass=findViewById(R.id.logIn_Password)

        loginbtn=findViewById(R.id.login_button)

        signupbtn=findViewById(R.id.Signup_button)

        signupbtn.setOnClickListener{
            val intent= Intent(this,signUp::class.java)
            startActivity(intent)
        }

        mAuth= FirebaseAuth.getInstance()

        loginbtn.setOnClickListener{
            val email =editemail.text.toString()

            val password =editpass.text.toString()

            login(email,password)

        }


    }

    private fun login(email:String, password:String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                  var intent=Intent(this, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "User Doesn't Exist",
                        Toast.LENGTH_SHORT).show()

                }
            }
    }
}