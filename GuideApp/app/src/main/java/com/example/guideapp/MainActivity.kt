package com.example.guideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.guideapp.fragments.Monument
import com.example.guideapp.fragments.Parks
import com.example.guideapp.fragments.Restaurant
import com.example.guideapp.fragments.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var viewPager:ViewPager
    lateinit var tabs:TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewpager)
        tabs = findViewById(R.id.tabs)

        setUpTabs()
    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Monument())
        adapter.addFragment(Parks())
        adapter.addFragment(Restaurant())
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)?.setText("Monuments")
        tabs.getTabAt(1)?.setText("Parks")
        tabs.getTabAt(2)?.setText("Restaurant")


    }
}