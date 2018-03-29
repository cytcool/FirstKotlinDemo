package com.example.cyt.firstkotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_personal_center.*

class PersonalCenterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_personal_center)
        setting.setOnClickListener {
            startActivity(Intent(PersonalCenterActivity@this, SettingActivity::class.java))
        }
    }
}
