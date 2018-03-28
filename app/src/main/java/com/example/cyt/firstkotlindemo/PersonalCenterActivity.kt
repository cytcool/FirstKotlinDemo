package com.example.cyt.firstkotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class PersonalCenterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_personal_center)
    }
}
