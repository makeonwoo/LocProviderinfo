package com.example.locproviderinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textInfo;
    LocationManager locManager;
    List<String> locProviderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInfo = findViewById(R.id.textinfo);
        locManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        locProviderList = locManager.getAllProviders();
        textInfo.setText("");
        for(String locProvName : locProviderList){
            textInfo.append("Loc.Provider: " +locProvName +"\n");
            textInfo.append("Enabled: " + locManager.isProviderEnabled(locProvName) + "\n\n");
        }
    }
}