package com.example.cyt.firstkotlindemo.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by CYT on 2018/3/20.
 */
class MyFragment: Fragment() {

    private var mRecycleView:RecyclerView?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (mRecycleView == null){
            mRecycleView= RecyclerView(activity)
            mRecycleView!!.layoutManager = LinearLayoutManager(activity)

            val url=arguments.getString("url")
            val type=arguments.getString("type")

            initRecyclerView(url)
        }
        return mRecycleView
    }

    private fun initRecyclerView(url:String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}