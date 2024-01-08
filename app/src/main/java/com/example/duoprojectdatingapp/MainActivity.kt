package com.example.duoprojectdatingapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //variables for UI elements
    private lateinit var hImageViewPic: ImageView
    private lateinit var roomName: TextView
    private lateinit var leftBtn: ImageView
    private lateinit var rightBtn: ImageView

    //variables to track the current image and room name index
    private var currentImage: Int = 0
    private var currentName: Int = 0

    //arrays to store room images and names
    private val imagesRight: ArrayList<Int> = ArrayList()
    private val imagesLeft: ArrayList<Int> = ArrayList()
    private val nameRight: ArrayList<String> = ArrayList()
    private val nameLeft: ArrayList<String> = ArrayList()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //button to navigate to My Room Activity
        val myRoomActbtn = findViewById<ImageView>(R.id.myRoomBtn)
        myRoomActbtn.setOnClickListener{
            val intent = Intent(this,MyRoomActivity::class.java)
            startActivity(intent)
        }

        //button to navigate to Chat Activity
        val ChatActbtn = findViewById<ImageView>(R.id.chatBtn)
        ChatActbtn.setOnClickListener{
            val intent = Intent(this,ChatActivity::class.java)
            startActivity(intent)
        }

        //initialize UI elements
        hImageViewPic = findViewById(R.id.roomOptions) as ImageView
        roomName = findViewById(R.id.roomName) as TextView
        leftBtn = findViewById(R.id.swipeLeft) as ImageView
        rightBtn = findViewById(R.id.swipeRight) as ImageView


        //initialize image arrays
        imagesRight.add(R.drawable.room1)
        imagesRight.add(R.drawable.room2)
        imagesRight.add(R.drawable.room3)
        imagesLeft.add(R.drawable.room4)
        imagesLeft.add(R.drawable.room5)

        //initialize name arrays
        nameRight.add("Jane's Room")
        nameRight.add("Jack's Room")
        nameRight.add("Lauren's Room")
        nameRight.add("Lea's Room")
        nameLeft.add("Karla's Room")
        nameLeft.add("Mario's Room")

        //set onClick lsteners for buttons
        leftBtn.setOnClickListener(leftButtonChangeImageListener)
        rightBtn.setOnClickListener(rightButtonChangeImageListener)
    }

    //onClick listener for left button
    private val leftButtonChangeImageListener = View.OnClickListener { view ->
        //increments the counter to the next image
        currentImage++
        currentImage = currentImage % imagesLeft.size
        hImageViewPic.setImageResource(imagesLeft[currentImage])

        //increments the counter to the next name
        currentName++
        currentName = currentName % nameLeft.size
        roomName.setText(nameLeft[currentName])
    }

    //onClick listener for right button
    var rightButtonChangeImageListener = View.OnClickListener { v: View ->
        //increments the counter to the next image
        currentImage++
        currentImage = currentImage % imagesRight.size
        hImageViewPic.setImageResource(imagesRight[currentImage])

        //increments the counter to the next name
        currentName++
        currentName = currentName % nameRight.size
        roomName.setText(nameRight[currentName])
    }
}
