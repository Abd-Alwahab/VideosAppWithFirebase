package com.bayanadam.videosappwithfirebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView

class Dashborad_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashborad_activity)


        var lesson1 = "https://firebasestorage.googleapis.com/v0/b/videosappwithfirebase.appspot.com/o/Android%20App%20Development%20Digram%20part%203.mp4?alt=media&token=fbc71201-cabb-4864-84cd-289a75e73a46"
        var lesson2 = "https://firebasestorage.googleapis.com/v0/b/videosappwithfirebase.appspot.com/o/Android%20App%20Development%20Digram%20part%204.mp4?alt=media&token=286f01e8-227c-4fb9-8c31-fc76e7bb891f"
        var lesson3 = "https://firebasestorage.googleapis.com/v0/b/videosappwithfirebase.appspot.com/o/Android%20App%20Development%20Digram%20part%205.mp4?alt=media&token=3420b27d-16ff-414f-a029-8679fe183d43"
        var lesson4 = "https://firebasestorage.googleapis.com/v0/b/videosappwithfirebase.appspot.com/o/Android%20App%20Development%20Digram%20part%206.mp4?alt=media&token=fd28cea7-8b1b-4efd-83e9-7ff8ef0e5b87"




        var items = ArrayList<Lesson>()
        items.add(Lesson("Android Development","Learn Android From Zero to Hero",lesson1))
        items.add(Lesson("Web Development","Learn Android From Zero to Hero",lesson2))
        items.add(Lesson("game Development","Learn Android From Zero to Hero",lesson3))
        items.add(Lesson(" Web Design","Learn Android From Zero to Hero",lesson4))


        val list = findViewById<RecyclerView>(R.id.videos_list)

        val adapter = Adapter(items,applicationContext)

        list.layoutManager = GridLayoutManager(applicationContext,1)

        list.adapter = adapter


    }
}
