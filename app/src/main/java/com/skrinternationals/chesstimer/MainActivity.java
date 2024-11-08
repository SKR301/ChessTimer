package com.skrinternationals.chesstimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview_primary_minute;
    TextView textview_primary_second;
    TextView textview_secondary_minute;
    TextView textview_secondary_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview_primary_minute = findViewById(R.id.textview_primary_minute);
        textview_primary_second = findViewById(R.id.textview_primary_second);
        textview_secondary_minute = findViewById(R.id.textview_secondary_minute);
        textview_secondary_second = findViewById(R.id.textview_secondary_second);


    }
}
