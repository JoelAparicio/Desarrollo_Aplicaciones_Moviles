package com.laboratorio.laboratorio9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    ImageButton play_pause;
    MediaPlayer mp;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play_pause= findViewById(R.id.play);
        image= findViewById(R.id.image);
        mp=MediaPlayer.create(this, R.raw.minero);
        image.setImageResource(R.drawable.aldeano);
        play_pause.setBackgroundResource(R.drawable.aldeano);
        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying())
                {
                    mp.pause();
                    Toast.makeText(MainActivity.this,"Pausa", Toast.LENGTH_SHORT).show();
                } else{
                    mp.start();

                Toast.makeText(MainActivity.this,"Play", Toast.LENGTH_SHORT).show();}
            }
        });
    }}


