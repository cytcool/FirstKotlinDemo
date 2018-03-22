package com.example.cyt.firstkotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_detail.*

/**
 * Created by CYT on 2018/3/22.
 */
class DetailActivity: AppCompatActivity() {


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
        val type=intent.getStringExtra("type")
        val is_like=intent.getBooleanExtra("is_like",false)

        detail_title.text=title
        if(is_like){
            detail_like.setImageResource(R.drawable.ic_love_full)
        }else{
            detail_like.setImageResource(R.drawable.ic_love_empty)
        }

        url="http:$url"
        detail_web_view.loadUrl(url)

        detail_back.setOnClickListener { finish() }

    }

    inner class MyWebClient: WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view!!.loadUrl(url)
            return super.shouldOverrideUrlLoading(view, url)
        }
    }

}