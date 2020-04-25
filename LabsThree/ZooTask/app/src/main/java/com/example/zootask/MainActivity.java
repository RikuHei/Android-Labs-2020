package com.example.zootask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mammals) {
            setContentView(R.layout.mammals);

            ImageButton bearButton = findViewById(R.id.bear);
            ImageButton wolfButton = findViewById(R.id.wolf);
            ImageButton elephantButton = findViewById(R.id.elephant);
            ImageButton lambButton = findViewById(R.id.lamb);


            final MediaPlayer bear = MediaPlayer.create(this, R.raw.bear);
            final MediaPlayer wolf = MediaPlayer.create(this, R.raw.wolf);
            final MediaPlayer elephant = MediaPlayer.create(this, R.raw.elephant);
            final MediaPlayer lamb = MediaPlayer.create(this, R.raw.lamb);

            bearButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bear.start();
                }
            });

            wolfButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wolf.start();
                }
            });

            elephantButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    elephant.start();
                }
            });

            lambButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lamb.start();
                }
            });

        } else if (item.getItemId() == R.id.birds) {
            setContentView(R.layout.birds);

            ImageButton owlButton = findViewById(R.id.huuhkaja);
            ImageButton peippoButton = findViewById(R.id.peippo);
            ImageButton peukaloinenButton = findViewById(R.id.peukaloinen);
            ImageButton punatulkkuButton = findViewById(R.id.punatulkku);


            final MediaPlayer huuhkaja = MediaPlayer.create(this, R.raw.huuhkaja_norther_eagle_owl);
            final MediaPlayer peippo = MediaPlayer.create(this, R.raw.peippo_chaffinch);
            final MediaPlayer peukaloinen = MediaPlayer.create(this, R.raw.peukaloinen_wren);
            final MediaPlayer punatulkku = MediaPlayer.create(this, R.raw.punatulkku_northern_bullfinch);

            owlButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    huuhkaja.start();
                }
            });

            peippoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    peippo.start();
                }
            });

            peukaloinenButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    peukaloinen.start();
                }
            });

            punatulkkuButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    punatulkku.start();
                }
            });
        }
        return true;
    }
}
