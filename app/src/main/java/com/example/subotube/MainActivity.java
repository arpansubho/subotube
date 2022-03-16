package com.example.subotube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    AudioManager audioManager;

    public void like(View view){
        Toast.makeText(this, "Video has been liked..", Toast.LENGTH_SHORT).show();
    }
    public void subscribe(View view){
        Toast.makeText(this, "Video has been subscribed..", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView baby = findViewById(R.id.baby);
        baby.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        MediaController m = new MediaController(this);
        baby.setMediaController(m);
        m.setAnchorView(baby);
        baby.start();




        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVol= audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


        SeekBar seekVol = findViewById(R.id.seekfunc);
        seekVol.setMax(maxVol);
        seekVol.setProgress(curVol);

        seekVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}