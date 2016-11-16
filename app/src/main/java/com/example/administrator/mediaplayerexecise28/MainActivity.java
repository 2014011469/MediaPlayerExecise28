package com.example.administrator.mediaplayerexecise28;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myTag";
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();

        final TextView txtLoopState = (TextView) findViewById(R.id.txtLoopState);

        final Button buttonStart = (Button) findViewById(R.id.buttonStart);
        final Button buttonPause = (Button) findViewById(R.id.buttonPause);
        final Button buttonStop = (Button) findViewById(R.id.buttonStop);
        final Button buttonLoop = (Button) findViewById(R.id.buttonLoop);

        buttonPause.setEnabled(false);
        buttonStop.setEnabled(false);
        buttonLoop.setEnabled(false);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.music);
                mediaPlayer.start();
                buttonPause.setEnabled(true);
                buttonStop.setEnabled(true);
                buttonLoop.setEnabled(true);
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {
                    buttonPause.setText("Play");
                    mediaPlayer.pause();
                } else {
                    buttonPause.setText("Pause");
                    mediaPlayer.start();
                }
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying())
                    mediaPlayer.stop();
            }
        });

        buttonLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Looping");

                boolean loop = mediaPlayer.isLooping();
                mediaPlayer.setLooping(!loop);


                if (!loop)
                    txtLoopState.setText("循环播放");
                else
                    txtLoopState.setText("一次播放");
            }
        });


    }
}
