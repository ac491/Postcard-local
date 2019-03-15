package com.example.postcard.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.postcard.Class.Options
import com.example.postcard.Fragments.Fragment_questionnaire
import com.example.postcard.R

class PagerAdapter internal constructor(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(p0: Int): Fragment? {
        val options = Options("here", R.drawable.place, 0)
        val option2 = Options("This one", R.drawable.place, 1)
        val list = ArrayList<Options>()
        list.add(options)
        list.add(option2)
        when(p0){
            0 -> return Fragment_questionnaire.newInstance("This is my question", list, 0)
            1 -> return Fragment_questionnaire.newInstance("This is my second question", list, 1)
            2 -> return Fragment_questionnaire.newInstance("This is my third question", list, 2)
        }
        return null
    }

    override fun getCount(): Int {
        return 3
    }


}