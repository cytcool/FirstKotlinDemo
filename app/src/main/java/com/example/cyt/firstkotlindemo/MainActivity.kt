package com.example.cyt.firstkotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.cyt.firstkotlindemo.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_main)
        main_viewpager.adapter=ViewPagerAdapter(supportFragmentManager)
        main_tab_layout.setupWithViewPager(main_viewpager)
    }
}
