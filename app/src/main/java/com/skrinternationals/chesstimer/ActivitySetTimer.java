package com.skrinternationals.chesstimer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySetTimer extends AppCompatActivity {

    NumberPicker numberpicker_player1;
    NumberPicker numberpicker_player2;
    Button button_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_timer);

        numberpicker_player1 = findViewById(R.id.numberpicker_player1);
        numberpicker_player2 = findViewById(R.id.numberpicker_player2);
        button_go = findViewById(R.id.button_go);

        numberpicker_player1.setMinValue(0);
        numberpicker_player1.setMaxValue(100);
        numberpicker_player1.setValue(10);
        numberpicker_player2.setMinValue(0);
        numberpicker_player2.setMaxValue(100);
        numberpicker_player2.setValue(10);

        button_go.setOnClickListener(v -> {
            Intent intent_activity_set_timer = new Intent(ActivitySetTimer.this, MainActivity.class);
            intent_activity_set_timer.putExtra("player1_time", String.valueOf(numberpicker_player1.getValue()));
            intent_activity_set_timer.putExtra("player2_time", String.valueOf(numberpicker_player2.getValue()));
            startActivity(intent_activity_set_timer);
        });
    }
}
