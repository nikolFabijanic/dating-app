package com.example.duoprojectdatingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class EditRoomActivity : AppCompatActivity() {

    //variables for UI elements
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2

    //adapter for managing fragments
    private lateinit var adapter: FragmentPageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_room)

        //initialize UI elements
        tabLayout = findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viewPager2)

        //initialize FragmentPageAdapter for managing fragments in ViewPager2
        adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)

        //add tabs to the TabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Bed"))
        tabLayout.addTab(tabLayout.newTab().setText("Closet"))
        tabLayout.addTab(tabLayout.newTab().setText("Table"))
        tabLayout.addTab(tabLayout.newTab().setText("Chair"))
        tabLayout.addTab(tabLayout.newTab().setText("Rug"))
        tabLayout.addTab(tabLayout.newTab().setText("Pet"))

        viewPager2.adapter = adapter

        //add a listener to handle tab selection
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //when a tab gets selected, update the current item in ViewPager2
                if (tab != null) {
                    viewPager2.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //no action needed when a tab is unselected
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //no action needed when a tab is reselected
            }

        })

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //when a page gets selected in ViewPager2, update the selected tab in TabLayout
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
}