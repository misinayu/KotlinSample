package com.example.musicplayersample;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button playBtn;
    private SeekBar positionBar;
    private SeekBar volumeBar;
    private TextView elapsedTimeLavel;
    private TextView remainingTimeLabel;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = findViewById(R.id.playBtn);
        elapsedTimeLavel = findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = findViewById(R.id.remainingTimeLabel);

        // Media Playerの初期化
        mp = MediaPlayer.create(this, R.raw.music01);
        mp.setLooping(true);
        mp.seekTo(0);
        mp.setVolume(0.5f, 0.5f);

        // 音量調整
        volumeBar = findViewById(R.id.volumeBar);
        volumeBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        float volumeNum = progress / 100f;
                        mp.setVolume(volumeNum, volumeNum);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }

    public void playBtnClick(View view) {
        if (!mp.isPlaying()) {
            // 停止中
            mp.start();
            playBtn.setBackgroundResource(R.drawable.stop);
        } else {
            // 再生中
            mp.pause();
            playBtn.setBackgroundResource(R.drawable.play);
        }
    }
}
