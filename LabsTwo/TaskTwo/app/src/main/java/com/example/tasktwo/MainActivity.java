package com.example.tasktwo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout horizontalLayout = new LinearLayout(this);
        LinearLayout verticalLayout = new LinearLayout(this);

        horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
        verticalLayout.setOrientation(LinearLayout.VERTICAL);

        Button countryAdd = new Button(this);
        Button countryEdit = new Button(this);
        Button countryDelete = new Button(this);

        countryAdd.setText("Add");
        countryEdit.setText("Edit");
        countryDelete.setText("Delete");

        ListView listView = new ListView(this);

        final EditText editText = new EditText(this);

        final ArrayList<String> countryArray = new ArrayList<String>();

        countryArray.add("Afghanistan");
        countryArray.add("Albania");
        countryArray.add("Algeria");
        countryArray.add("American Samoa");
        countryArray.add("Bangladesh");
        countryArray.add("Andorra");
        countryArray.add("Angola");
        countryArray.add("Anguilla");
        countryArray.add("Antarctica");
        countryArray.add("Antigua and Barbuda");
        countryArray.add("Argentina");
        countryArray.add("Armenia");
        countryArray.add("Aruba");
        countryArray.add("Australia");
        countryArray.add("Austria");
        countryArray.add("Azerbaijan");

        List<String> list = countryArray;
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        countryAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String editTextValue = editText.getText().toString();
                countryArray.add(editTextValue);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        countryDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String editTextValue = editText.getText().toString();
                countryArray.remove(editTextValue);
                arrayAdapter.notifyDataSetChanged();
            }
        });


        listView.setAdapter(arrayAdapter);
        verticalLayout.addView(horizontalLayout);
        horizontalLayout.addView(countryAdd);
        horizontalLayout.addView(countryEdit);
        horizontalLayout.addView(countryDelete);
        verticalLayout.addView(editText);
        verticalLayout.addView(listView);
        setContentView(verticalLayout);

    }
}
