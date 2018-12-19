package com.bayanadam.videosappwithfirebase

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import tcking.github.com.giraffeplayer2.VideoView

class Adapter(data:ArrayList<Lesson>,var context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {



    var data:List<Lesson>

    init {
        this.data = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.video_item,parent,false)

        return ViewHolder(layout)

    }


    override fun onBindViewHolder(holder: ViewHolder, postion: Int) {


        val videoItem = data[postion]

        holder.title.text = videoItem.title
        holder.desc.text = videoItem.desc
        holder.video.setVideoPath(videoItem.videoUrl)
        holder.download.setOnClickListener {


            var download = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            var videoUri = Uri.parse(videoItem.videoUrl)
            var GetVideo = DownloadManager.Request(videoUri)
            GetVideo.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            download.enqueue(GetVideo)


        }

    }


    override fun getItemCount(): Int {

        return data.size
    }





    class ViewHolder(item:View) : RecyclerView.ViewHolder(item)  {


        var title:TextView
        var desc:TextView
        var video:VideoView
        var download: Button


        init {


            title = item.findViewById(R.id.video_title)
            desc = item.findViewById(R.id.video_dec)
            video = item.findViewById(R.id.lesson_video)
            download = item.findViewById(R.id.video_download)
        }

    }
}