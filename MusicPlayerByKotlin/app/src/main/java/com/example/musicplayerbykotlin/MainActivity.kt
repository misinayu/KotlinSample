package com.example.musicplayerbykotlin

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playBtn: Button = findViewById(R.id.playBtn) as Button
        val positionBar: SeekBar = findViewById(R.id.positionBar) as SeekBar
        val volumeBar: SeekBar = findViewById(R.id.volumeBar) as SeekBar
        val elapsedTimeLabel: TextView = findViewById(R.id.elapsedTimeLabel) as TextView
        val remainingTimeLabel: TextView = findViewById(R.id.remainingTimeLabel) as TextView

        // Media Playerの初期化
    }
}
