package com.bayanadam.videosappwithfirebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun Register_btn(view:View) {

        startActivity(Intent(this@MainActivity,Register_activity::class.java))
    }

    fun Login_btn(view: View) {

        startActivity(Intent(this@MainActivity,Login_activity::class.java))
    }
}
