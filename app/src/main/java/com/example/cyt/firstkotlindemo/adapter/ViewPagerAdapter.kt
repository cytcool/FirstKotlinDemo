package com.example.cyt.firstkotlindemo.adapter


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.cyt.firstkotlindemo.fragment.MyFragment

/**
 * Created by CYT on 2018/3/20.
 */
class ViewPagerAdapter(val fm:FragmentManager):FragmentPagerAdapter(fm){

    val items = listOf("Android","IOS","PHP","JavaScript","Python")
    val urls= listOf("http://www.jikexueyuan.com/path/android"
                    ,"http://www.jikexueyuan.com/path/ios"
                    ,"http://www.jikexueyuan.com/path/php"
                    ,"http://www.jikexueyuan.com/path/javascript"
                    ,"http://www.jikexueyuan.com/path/python")

    override fun getItem(position: Int): Fragment? {
        val bundle=Bundle()
        bundle.putString("type",items[position])
        bundle.putString("url",urls[position])
        val fragment=MyFragment()
        fragment.arguments=bundle
        return fragment
    }

    override fun getCount(): Int {
      return items.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return items[position]
    }
}