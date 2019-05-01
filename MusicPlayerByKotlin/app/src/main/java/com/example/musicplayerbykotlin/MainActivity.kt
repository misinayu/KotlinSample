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
        var mp: MediaPlayer? = MediaPlayer.create(this, R.raw.music01)
        mp?.isLooping
        mp?.seekTo(0)
        mp?.setVolume(0.5f, 0.5f)
        val totalTime: Int = mp?.duration as Int

        // 再生位置
        positionBar.max = totalTime
        positionBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        mp?.seekTo(progress)
                        positionBar.setProgress(progress)
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
        )

        // 音量調整
        volumeBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    val volumeNum: Float = progress / 100f
                    mp?.setVolume(volumeNum, volumeNum)
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
        )
    }
}
