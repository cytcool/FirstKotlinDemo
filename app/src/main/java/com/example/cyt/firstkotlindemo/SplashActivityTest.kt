package com.example.cyt.firstkotlindemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity


/**
 * Created by CYT on 2018/3/26.
 */
class SplashActivityTest : AppCompatActivity(){

    private val HANDLER_SPLASH=1001

    private val handler : Handler = @SuppressLint("HandlerLeak")
    object :Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            startActivity(Intent(this@SplashActivityTest, MainActivity::class.java))
            finish()
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar!!.hide()
        handler.sendEmptyMessageDelayed(HANDLER_SPLASH, 2000)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}