package com.example.musicplayerbykotlin

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var totalTime: Int = 0
    var mp: MediaPlayer? = null
    var playBtn: Button = null as Button
    var elapsedTimeLabel: TextView = null as TextView
    var remainingTimeLabel: TextView = null as TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playBtn = findViewById(R.id.playBtn) as Button
        elapsedTimeLabel = findViewById(R.id.elapsedTimeLabel) as TextView
        remainingTimeLabel = findViewById(R.id.remainingTimeLabel) as TextView

        val positionBar: SeekBar = findViewById(R.id.positionBar) as SeekBar
        val volumeBar: SeekBar = findViewById(R.id.volumeBar) as SeekBar

        // Media Playerの初期化
        mp = MediaPlayer.create(this, R.raw.music01)
        mp?.isLooping
        mp?.seekTo(0)
        mp?.setVolume(0.5f, 0.5f)
        totalTime = mp?.duration as Int

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

        // Thread (positionBar・経過時間ラベル・残り時間ラベルを更新する)
        val thread = Thread(
            object : Runnable {
                override fun run() {
                    while (mp != null) {
                        try {
                            val msg : Message = Message()
                            msg.what = mp!!.currentPosition
                            handler.sendMessage(msg)
                            Thread.sleep(1000)
                        } catch (e: InterruptedException) {}
                    }
                }
            }
        )
        thread.start()
    }

    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            val currentPosition: Int = msg.what

            // 再生位置を更新
            positionBar.setProgress(currentPosition)

            // 経過時間ラベルを更新
            val elapsedTime: String = createTimeLabel(currentPosition)
            elapsedTimeLabel.setText(elapsedTime)

            // 残り時間ラベル更新
            val remainingTime: String = createTimeLabel(totalTime - currentPosition)
            remainingTimeLabel.setText("- " + remainingTime)
        }
    }

    fun createTimeLabel(time: Int): String {
        var timeLabel: String = ""
        val min: Int = time / 1000 / 60
        val sec: Int = time /1000 % 60

        timeLabel = "${min}:"
        if (sec < 10) timeLabel += "0"
        timeLabel += sec

        return timeLabel
    }

    fun playBtnClick(view: View) {
        if (mp!!.isPlaying) {
            // 停止中
            mp?.start()
            playBtn.setBackgroundResource(R.drawable.stop)
        } else {
            // 再生中
            mp?.pause()
            playBtn.setBackgroundResource(R.drawable.play)
        }
    }
}
