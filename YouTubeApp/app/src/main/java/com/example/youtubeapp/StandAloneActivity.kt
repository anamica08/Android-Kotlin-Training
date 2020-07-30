package com.example.youtubeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_stand_alone.*

class StandAloneActivity : AppCompatActivity(), View.OnClickListener {


    val VIDEO_ID = "hdI2bqOjy3c"
    val PLAYLIST =  "PLillGF-RfqbbnEGy3ROiLWk7JMCuSyQtX"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stand_alone)

        videoButton.setOnClickListener(this)
        playlistButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        var intent  = when(p0?.id){
            R.id.videoButton ->YouTubeStandalonePlayer.createVideoIntent(
                this, getString(R.string.Google_api_key), VIDEO_ID)
            R.id.playlistButton -> YouTubeStandalonePlayer.createPlaylistIntent(
                this, getString(R.string.Google_api_key), PLAYLIST)
            else -> throw IllegalArgumentException("Undefined button clicked")
        }
        startActivity(intent)
    }
}