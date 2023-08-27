package com.polware.foodrecipes.view.adapters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

// La variable tipo Bundle permite enviar datos Parcelable a los Fragments
class ViewPagerAdapter(private val resultBundle: Bundle, private val fragments: ArrayList<Fragment>,
                       activity: AppCompatActivity): FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        fragments[position].arguments = resultBundle
        return fragments[position]
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

}