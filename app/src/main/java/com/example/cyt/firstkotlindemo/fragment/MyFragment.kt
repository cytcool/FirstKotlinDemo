package com.example.cyt.firstkotlindemo.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cyt.firstkotlindemo.adapter.MyAdapter
import com.example.cyt.firstkotlindemo.entity.ItemEntity
import com.example.cyt.firstkotlindemo.event.LikeEvent
import com.example.cyt.firstkotlindemo.utils.RxBus
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jsoup.Jsoup


/**
 * Created by CYT on 2018/3/20.
 */
class MyFragment: Fragment() {

    private var mRecycleView:RecyclerView?=null
    private var mList= mutableListOf<ItemEntity>()

    private var mType:String?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (mRecycleView == null){
            mRecycleView= RecyclerView(activity)
            mRecycleView!!.layoutManager = LinearLayoutManager(activity)

            val url=arguments.getString("url")
                mType=arguments.getString("type")

            initRecyclerView(url)

            registerRxBus()
        }
        return mRecycleView
    }

    private fun registerRxBus() {
        RxBus.getInstance().toObservable().subscribe{
            event->
            when(event){
                is LikeEvent->handleLikeEvent(event)
            }
        }

    }

    private fun handleLikeEvent(event: LikeEvent) {
        save_database(event)
        update_ui(event)
    }

    private fun update_ui(event: LikeEvent) {
        mList.filter { it.url==event.url }.forEach {
            it.is_like=event.is_like
        }
        mRecycleView!!.adapter.notifyDataSetChanged()
    }

    private fun save_database(event: LikeEvent) {
        async(UI){
            val task= bg {

            }
        }
    }


    private fun initRecyclerView(url:String) {
        async(UI){
            val result=bg{
                val jsoup= Jsoup.connect(url).get()
                val uls=jsoup.select("ul.cf")
                for(x in uls){
                    val lis=x.select("li")
                    for(i in lis){
                        val title=i.select("div.lesson-infor > h2 > a").text()
                        val item_url=i.select("div.lesson-infor > h2 > a").attr("href")
                        val describe=i.select("div.lesson-infor > p").text()
                        val image=i.select("div.lessonimg-box > a > img").attr("src")
                        val time_and_class=i.select("div.lesson-infor > div > div:nth-child(1) > dl > dd.mar-b8 > em").text()

                        val entity=ItemEntity(title=title,url = item_url,describe = describe,image = image
                                ,time_and_class = time_and_class,is_like = false)
                        mList.add(entity)
                    }
                }
            }
            result.await()
            mRecycleView!!.adapter=MyAdapter(mList,mType!!)
        }
    }
}