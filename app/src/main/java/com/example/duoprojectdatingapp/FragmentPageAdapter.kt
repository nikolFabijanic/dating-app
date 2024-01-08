package com.example.duoprojectdatingapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    //method to specify the total number of fragments
    override fun getItemCount(): Int {
        return 6 //total number of fragments
    }

    //method to create a new fragment instance based on its position
    override fun createFragment(position: Int): Fragment {
        //create and return a different fragment based on the position
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            3 -> FourthFragment()
            4 -> FifthFragment()
            else -> {SixthFragment()}
        }
    }
}