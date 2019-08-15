package com.example.room

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room.Entity.StudentEntity

class StudentAdapter(val context:Context,var list : List<StudentEntity> = listOf()) : RecyclerView.Adapter<StudentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row,parent,false))
    }


    fun updateStudent(listUpdate : List<StudentEntity>){
        list = listUpdate
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.tvCode.text = list[position].code.toString()
        holder.tvEmail.text = list[position].email
        holder.tvFirstname.text = list[position].firstName
        holder.tvLastname.text = list[position].lastName
        holder.tvAddress.text = list[position].address

    }
}
class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvCode = itemView.findViewById<TextView>(R.id.txt_id)
    val tvEmail = itemView.findViewById<TextView>(R.id.txt_email)
    val tvFirstname = itemView.findViewById<TextView>(R.id.txt_fname)
    val tvLastname = itemView.findViewById<TextView>(R.id.txt_lname)
    val tvAddress = itemView.findViewById<TextView>(R.id.txt_address)
}