package com.skrinternationals.chesstimer;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView textview_player1_minute;
    TextView textview_player1_second;
    TextView textview_player2_minute;
    TextView textview_player2_second;
    ImageView imageView_overlay;

    boolean is_running = false;
    boolean player1_timer_is_on = false;

    CountDownTimer timer1;
    CountDownTimer timer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        imageView_overlay.setOnClickListener(v-> {
            if (!is_running) {
                startTimerForPlayer1();
                is_running = true;
                imageView_overlay.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
            } else {
                if (player1_timer_is_on) {
                    stopTimerForPlayer1();
                    startTimerForPlayer2();
                } else {
                    stopTimerForPlayer2();
                    startTimerForPlayer1();
                }
            }
            player1_timer_is_on = !player1_timer_is_on;
        });
    }

    private void stopTimerForPlayer1() {
        timer1.cancel();
    }

    private void stopTimerForPlayer2() {
        timer2.cancel();
    }

    private void startTimerForPlayer1() {
        long player1_time_in_millis = (Integer.parseInt((String) textview_player1_minute.getText()) * 60L + Integer.parseInt((String) textview_player1_second.getText())) * 1000;
        timer1 = new CountDownTimer(player1_time_in_millis, 1000) {

            @Override
            public void onTick(long millis_until_finished) {
                long minutes = (millis_until_finished / 1000) / 60;
                long seconds = (millis_until_finished / 1000) % 60;

                textview_player1_minute.setText(String.format(Locale.ENGLISH, "%02d", minutes));
                textview_player1_second.setText(String.format(Locale.ENGLISH, "%02d", seconds));
            }

            @Override
            public void onFinish() {
//                reset
                is_running = false;
                imageView_overlay.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.transparent));
                Toast.makeText(MainActivity.this, "Time's up", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    private void startTimerForPlayer2() {
        long player2_time_in_millis = (Integer.parseInt((String) textview_player2_minute.getText()) * 60L + Integer.parseInt((String) textview_player2_second.getText())) * 1000;
        timer2 = new CountDownTimer(player2_time_in_millis, 1000) {
            @Override
            public void onTick(long millis_until_finished) {
                long minutes = (millis_until_finished / 1000) / 60;
                long seconds = (millis_until_finished / 1000) % 60;

                textview_player2_minute.setText(String.format(Locale.ENGLISH, "%02d", minutes));
                textview_player2_second.setText(String.format(Locale.ENGLISH, "%02d", seconds));
            }

            @Override
            public void onFinish() {
//                reset
                is_running = false;
                imageView_overlay.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.transparent));
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
