package com.example.num1.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity){ //FragmentStateAdapter는 추상클래스이며, Recyclerview.adapter를 상속받기에 리사이클러뷰와 동일한 원리로 작동한다.
        val fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int = fragments.size   //어댑터에서 만들 페이지 수 fragmentsize를 반환함

    override fun createFragment(position: Int): Fragment = fragments[position]
    /*
    꼭 들어가야 되는 두개가 getItemCount랑 createFragment이다.
     */
}