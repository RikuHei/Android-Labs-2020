package com.example.externaltask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openMap = (Button) findViewById(R.id.mapButton);
        Button callButton = (Button) findViewById(R.id.createCall);
        Button goButton = findViewById(R.id.goButton);
        final EditText editText = (EditText) findViewById(R.id.websiteAddress);

        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo: 0,0?q=Oulun Ammattikorkeakoulu( Oamk ), Kotkantie 1, Oulu");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
                boolean isIntentSafe = ((List) activities).size() > 0;

                if (isIntentSafe) {
                    startActivity(mapIntent);
                }
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri phoneNumber = Uri.parse("tel: 5555555555");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, phoneNumber);

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(callIntent, 0);
                boolean isIntentSafe = ((List) activities).size() > 0;

                if (isIntentSafe) {
                    startActivity(callIntent);
                }
            }
        });

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextValue = editText.getText().toString();
                Uri websiteAddress = Uri.parse(editTextValue);
                Intent openSite = new Intent(Intent.ACTION_VIEW, websiteAddress);

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(openSite, 0);
                boolean isIntentSafe = ((List) activities).size() > 0;

                if (isIntentSafe) {
                    startActivity(openSite);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
        }
        return true;
    }
}
