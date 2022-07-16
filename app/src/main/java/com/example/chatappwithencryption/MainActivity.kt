package com.example.chatappwithencryption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var userReclylerView: RecyclerView
    private lateinit var userList: ArrayList<User>
    private lateinit var adapter:user_adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_ChatAppWithEncryption)
        setContentView(R.layout.activity_main)

        userList= ArrayList()
        adapter=user_adapter(this,userList)




    }
}