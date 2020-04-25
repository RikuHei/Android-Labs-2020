package com.example.greetingtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String inputString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String english = "Hello ";
        final String swedish = "Hejsan ";
        final String finnish = "Terve ";

        EditText userInput = findViewById(R.id.userGreeting);

        final TextView greet = findViewById(R.id.greet);

        final TextView inputValue = findViewById(R.id.userInput);

        userInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String string = s.toString();
                inputString = string;
                inputValue.setText(inputString);

            }
        });

        Button englishButton = findViewById(R.id.english);
        Button finnishButton = findViewById(R.id.finnish);
        Button swedishButton = findViewById(R.id.swedish);
        Button surpriseButton = findViewById(R.id.surprise);

        englishButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                greet.setText(english);
            }
        });

        finnishButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                greet.setText(finnish);
            }
        });

        swedishButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                greet.setText(swedish);
            }
        });

        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] greetingArray = new String[]{
                       "Salut ", " ¿Qué tal? ", "Privet ", "Ciao ", "Konnichiwa ", "Oi "
                };
                int randomInt = new Random().nextInt(greetingArray.length);
                final String surprise = greetingArray[randomInt];
                greet.setText(surprise);
            }
        });


    }
}
