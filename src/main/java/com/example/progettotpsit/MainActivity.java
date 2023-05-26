package com.example.progettotpsit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

import com.example.progettotpsit.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Button> mButtons = new ArrayList<>();
    private ArrayList<MediaPlayer> mediaPlayerArrayList = new ArrayList<>();

    private static final int[] NOTE_FILES = {
            R.raw.a,
            R.raw.b,
            R.raw.c,
            R.raw.d,
            R.raw.e,
            R.raw.f,
            R.raw.g,
            R.raw.c2,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().getDecorView().setBackgroundColor(Color.BLACK);
        this.getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_FULLSCREEN
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        addButtonsToArrayList();

        // final MediaPlayer mp = MediaPlayer.create(this, R.raw.metal_pipe);
        for(int note : NOTE_FILES){
            mediaPlayerArrayList.add(MediaPlayer.create(this, note));
        }

        int i = 0;
        for (Button button : mButtons) {
            int finalI = i;
            button.setOnClickListener(v -> {
                if(mediaPlayerArrayList.get(finalI).isPlaying()){
                    mediaPlayerArrayList.get(finalI).seekTo(0);
                }
                mediaPlayerArrayList.get(finalI).start();
            });
            i += 1;
        }
    }

    private void addButtonsToArrayList() {
        mButtons.add(binding.button1);
        mButtons.add(binding.button2);
        mButtons.add(binding.button3);
        mButtons.add(binding.button4);
        mButtons.add(binding.button5);
        mButtons.add(binding.button6);
        mButtons.add(binding.button7);
        mButtons.add(binding.button8);
    }
}