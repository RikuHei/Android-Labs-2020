package com.example.timertask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String inputValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startTimer = (Button) findViewById(R.id.startTimer);
        final EditText userTime = (EditText) findViewById(R.id.userTime);

        startTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInputValue = userTime.getText().toString();
                inputValue = userInputValue;
                openCounterActivity();
            }
        });
    }

    public void openCounterActivity(){
        Intent intent = new Intent(MainActivity.this, CounterActivity.class);
        intent.putExtra("userInput", inputValue);
        startActivity(intent);
    }
}
