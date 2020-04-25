package com.example.partone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        final Button gameButton = new Button(this);

        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               count++;
               gameButton.setText("You have pressed the button " + count + " times");
            }
        });

        gameButton.setText("You have pressed the button 0 times");

        setContentView(gameButton);

    }
}
