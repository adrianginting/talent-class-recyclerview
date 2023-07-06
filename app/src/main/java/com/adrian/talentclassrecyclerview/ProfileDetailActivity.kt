package com.adrian.talentclassrecyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ProfileDetailActivity : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var email: TextView
    private lateinit var major: TextView
    private lateinit var semester: TextView
    private lateinit var image: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)

        name = findViewById(R.id.tvName)
        email = findViewById(R.id.tvEmail)
        major = findViewById(R.id.tvMajor)
        semester = findViewById(R.id.tvSemester)
        image = findViewById(R.id.imgProfile)

        val extras = intent.extras

        if (extras != null) {
            name.text = extras.getString("name")
            email.text = extras.getString("email")
            major.text = extras.getString("major")
            semester.text = extras.getString("semester")
            val resId: Int = extras.getInt("imageUri")
            image.setImageResource(resId)
            val imageUriString = extras.getString("imageUri")
            if (imageUriString != null) {
                //val imageUri = Uri.parse(imageUriString)
                Glide.with(this)
                    .load(resId)
                    .centerCrop()
                    .placeholder(R.drawable.img_logo_talenthub)
                    .into(image)
            }
        }
    }
}