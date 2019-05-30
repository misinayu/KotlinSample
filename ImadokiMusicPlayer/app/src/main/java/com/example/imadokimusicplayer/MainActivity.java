package com.example.imadokimusicplayer;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaBrowserCompat mBrowser;
    MediaControllerCompat mController;

    // UI関係の宣言
    TextView textView_title;
    TextView textView_position;
    TextView textView_duration;
    ImageButton button_prev;
    ImageButton button_next;
    FloatingActionButton button_play;
    ImageView imageView;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO::UIのセットアップ
        textView_title = findViewById(R.id.textView_title);


        // サービスを開始する
        // Activity破棄と同時にServiceも停止して良いならこれは不要
        startService(new Intent(this, MusicService.class));
    }
}
