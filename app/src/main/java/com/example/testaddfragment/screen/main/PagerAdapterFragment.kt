package com.example.testaddfragment.screen.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapterFragment(var fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    var arrayFragment = ArrayList<Fragment> ()
    var arrayTitle = ArrayList<String>()


    override fun getCount(): Int {
        return arrayFragment.size
    }

    override fun getItem(position: Int): Fragment {
        return arrayFragment.get(position)
    }

    fun addFragment(fragment: Fragment, title: String) {
        arrayFragment.add(fragment)
        arrayTitle.add(title)
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return arrayTitle[position]
    }
}