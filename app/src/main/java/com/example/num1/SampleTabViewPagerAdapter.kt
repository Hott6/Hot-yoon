package com.example.num1;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

class SampleTabViewPagerAdapter(fragment:Fragment)
    :FragmentStateAdapter(fragment){
    val fragments=mutableListOf<Fragment>()
    override fun getItemCount():Int=fragments.size
    override fun createFragment(position:Int)=fragments[position]

}
