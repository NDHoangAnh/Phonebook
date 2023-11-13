package com.example.gmail_recycle

import User
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.MainActivity2
import com.example.phonebook.R

class MyAdapter(val user: List<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var clickedUser: User? = null

    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val user = row.findViewById<TextView>(R.id.user)
        val userLetter = row.findViewById<TextView>(R.id.userLetter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item,
            parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.user.text = user[position].getUserName()
        holder.userLetter.text = user[position].getUserName().substring(0, 1).toUpperCase()

        holder.itemView.setOnClickListener {
            val context = it.context
            clickedUser = user[position]
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra("Id", clickedUser!!.id)
            intent.putExtra("Name", clickedUser!!.getUserName())
            intent.putExtra("Number", clickedUser!!.getUserPhone())
            intent.putExtra("Email", clickedUser!!.getUserEmail())
            context.startActivity(intent)
            if (clickedUser != null) {
                Log.d("TAG", clickedUser.toString())
            }
        }

        holder.itemView.setOnCreateContextMenuListener { menu, _, _ ->
            clickedUser = user[position]
            menu.add(0, R.id.action_call, 0, "Call")
            menu.add(0, R.id.action_send_message, 0, "Send message")
            menu.add(0, R.id.action_send_email, 0, "Send email")
        }
    }

    override fun getItemCount(): Int = user.size

    fun getClickedUser(): User? = clickedUser
}