package com.example.chatappwithencryption

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signUp : AppCompatActivity() {

    var TAG:String="SignUp"

    private lateinit var editemail: EditText
    private lateinit var editpass: EditText

    private lateinit var signupbtn: Button
    private lateinit var name:EditText

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mdatabaseref:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()


        name=findViewById(R.id.name)

        editemail=findViewById(R.id.logIn_email)

        editpass=findViewById(R.id.logIn_Password)



        signupbtn=findViewById(R.id.Signup_button)



        mAuth= FirebaseAuth.getInstance()

        signupbtn.setOnClickListener{

            val name=name.text.toString()
            val email =editemail.text.toString()

            val password =editpass.text.toString()

            signup(name,email,password)

        }


    }

    private fun signup(name:String,email:String, password:String){

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                        addusertodatabase(name,email,mAuth.currentUser?.uid!!)
                    val intent=Intent(this,MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(this,"please Try Again",Toast.LENGTH_SHORT).show()
                }
            }

    }

    private fun addusertodatabase(name: String,email: String ,uid:String){
      mdatabaseref= FirebaseDatabase.getInstance().getReference(

          mdatabaseref.child("user").child(uid).setValue(User(name,email,uid)).toString()


      )

    }

    }
