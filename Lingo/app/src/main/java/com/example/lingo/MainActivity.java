package com.example.lingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
//import com.example.Gridview.databinding.ActivityMainBinding;
import android.widget.GridView.*;


public class MainActivity extends AppCompatActivity {

    Button instructions;
    Button play;
    MediaPlayer click;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = MediaPlayer.create(this, R.raw.bruh);
        click.setVolume(1f,1f);
        play = (Button) findViewById(R.id.playButton);
        instructions = (Button) findViewById(R.id.instrcutionButton);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Gamescreen.class);
                click.start();
                startActivity(intent);
            }
        });

        instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_instruction.class);
                click.start();
                startActivity(intent);
            }
        });
    }
}