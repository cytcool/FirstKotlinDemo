package com.example.cyt.firstkotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.cyt.firstkotlindemo.event.LikeEvent
import com.example.cyt.firstkotlindemo.utils.RxBus
import kotlinx.android.synthetic.main.activity_detail.*

/**
 * Created by CYT on 2018/3/22.
 */
class DetailActivity: AppCompatActivity() {

    private var is_like=false
    private var type=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_detail)
        initView()
    }




    private fun initView() {
        val settings=detail_web_view.settings
        settings.javaScriptEnabled=true
        settings.setSupportZoom(true)
        settings.useWideViewPort=true
        settings.loadWithOverviewMode=true
        settings.layoutAlgorithm=WebSettings.LayoutAlgorithm.SINGLE_COLUMN

        detail_web_view.webViewClient=MyWebClient()

        var url=intent.getStringExtra("url")
        val title=intent.getStringExtra("title")
        type=intent.getStringExtra("type")
        is_like=intent.getBooleanExtra("is_like",false)

        detail_title.text=title
        set_like_status()

        url="http:$url"
        detail_web_view.loadUrl(url)

        detail_back.setOnClickListener { finish() }
        detail_like.setOnClickListener {
            is_like=!is_like
            RxBus.getInstance().send(LikeEvent(type = type,url = url,is_like = is_like))
            set_like_status()
        }

    }

    private fun set_like_status(){
        if(is_like){
            detail_like.setImageResource(R.drawable.ic_love_full)
        }else{
            detail_like.setImageResource(R.drawable.ic_love_empty)
        }
    }

    inner class MyWebClient: WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view!!.loadUrl(url)
            return super.shouldOverrideUrlLoading(view, url)
        }
    }

}