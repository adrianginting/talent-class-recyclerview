package com.adrian.talentclassrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListProfileAdapter(private val listProfile: ArrayList<Profile>): RecyclerView.Adapter<ListProfileAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_profile, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, email, major, semester, photo) = listProfile[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvEmail.text = email
        holder.tvMajor.text = major
        holder.tvSemester.text = "Semester $semester"

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Membuka Profile $name", Toast.LENGTH_SHORT).show()
            val intent = Intent(holder.itemView.context, ProfileDetailActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("major", major)
            intent.putExtra("semester", semester)
            intent.putExtra("imageUri", photo)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listProfile.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvEmail: TextView = itemView.findViewById(R.id.tv_item_email)
        val tvMajor: TextView = itemView.findViewById(R.id.tv_item_major)
        val tvSemester: TextView = itemView.findViewById(R.id.tv_item_semester)
    }
}