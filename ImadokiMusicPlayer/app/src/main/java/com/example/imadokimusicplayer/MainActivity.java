package com.example.imadokimusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MediaBrowserCompat mBrowser;
    MediaControllerCompat mController;

    // TODO::UI関係の宣言

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO::UIのセットアップ

        // サービスを開始する
        // Activity破棄と同時にServiceも停止して良いならこれは不要
        startService(new Intent(this, MusicService.class));
    }
}
