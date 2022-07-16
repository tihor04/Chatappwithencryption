package com.example.chatappwithencryption

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class user_adapter(val context: Context,val userlist: ArrayList<User>) : RecyclerView.Adapter<user_adapter.userViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
    val view:View=LayoutInflater.from(context).inflate(R.layout.user_layout,parent,false)
        return userViewHolder(view)
    }

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
      val currentUser=userlist[position]

        holder.textname.text=currentUser.name
    }

    override fun getItemCount(): Int {
   return userlist.size
    }

    class userViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    val textname=itemView.findViewById<TextView>(R.id.user_layout_text)

    }
}

