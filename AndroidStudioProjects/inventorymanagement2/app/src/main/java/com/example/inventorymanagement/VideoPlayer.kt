package com.example.inventorymanagement

import android.net.Uri
import android.view.View
import kotlinx.android.synthetic.main.content_main.*
import android.widget.Toast
import com.example.inventorymanagement.R.raw.track1
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_products.*
import android.content.Intent
import android.app.TaskStackBuilder.create
import android.media.MediaPlayer
import android.media.MediaPlayer.create
import android.support.v4.app.RemoteActionCompatParcelizer
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_products.*
import kotlinx.android.synthetic.main.video_page.*
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.create

class VideoPlayer: AppCompatActivity() {
    private var mediaController: MediaController? = null

        private fun configureVideoView() {

        video_view.setVideoPath("android.resource://" + packageName + "/" + R.raw.niti)

        mediaController = MediaController(this)
        mediaController?.setAnchorView(video_view)
        video_view.setMediaController(mediaController)
        video_view.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_page)
        configureVideoView()
    }
}