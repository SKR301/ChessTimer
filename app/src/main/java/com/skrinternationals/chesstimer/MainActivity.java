package com.skrinternationals.chesstimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView textview_player1_minute;
    TextView textview_player1_second;
    TextView textview_player2_minute;
    TextView textview_player2_second;
    ImageView imageView_overlay;

    boolean player1_timer_is_on = false;

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        imageView_overlay.setOnClickListener(v-> {
            if ((player1_timer_is_on)) {
                startTimerForPlayer2();
            } else {
                startTimerForPlayer1();
            }
            player1_timer_is_on = !player1_timer_is_on;
        });

    }

    private void startTimerForPlayer1() {
        long player1_time_in_millis = Integer.parseInt((String) textview_player1_minute.getText()) * 60L + Integer.parseInt((String) textview_player1_minute.getText());
        timer = new CountDownTimer(player1_time_in_millis, 1000) {

            @Override
            public void onTick(long millis_until_finished) {
                long minutes = (millis_until_finished / 1000) / 60;
                long seconds = (millis_until_finished / 1000) % 60;

                textview_player1_minute.setText((int) minutes);
                textview_player1_second.setText((int) seconds);
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Time's up", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    private void startTimerForPlayer2() {
        long player2_time_in_millis = Integer.parseInt((String) textview_player2_minute.getText()) * 60L + Integer.parseInt((String) textview_player2_minute.getText());
        timer = new CountDownTimer(player2_time_in_millis, 1000) {

            @Override
            public void onTick(long millis_until_finished) {
                long minutes = (millis_until_finished / 1000) / 60;
                long seconds = (millis_until_finished / 1000) % 60;

                textview_player2_minute.setText((int) minutes);
                textview_player2_second.setText((int) seconds);
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Time's up", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    void initialize() {
        textview_player1_minute = findViewById(R.id.textview_player1_minute);
        textview_player1_second = findViewById(R.id.textview_player1_second);
        textview_player2_minute = findViewById(R.id.textview_player2_minute);
        textview_player2_second = findViewById(R.id.textview_player2_second);
        imageView_overlay = findViewById(R.id.imageView_overlay);
    }
}
