package com.example.duoprojectdatingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MyRoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_room)

        //button to navigate to Edit Room Activity
        val editRoomActbtn = findViewById<Button>(R.id.editButton)
        editRoomActbtn.setOnClickListener{
            val intent = Intent(this,EditRoomActivity::class.java)
            startActivity(intent)
        }
    }
}


