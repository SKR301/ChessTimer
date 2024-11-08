package com.skrinternationals.chesstimer;

public class Timer {
    private int m_time_in_sec;

    Timer() {
        m_time_in_sec = 600;
    }

    Timer(int time_in_sec) {
        m_time_in_sec = time_in_sec;
    }

    public void setTimeInSec(int time_in_sec) {
        m_time_in_sec = time_in_sec;
    }

    public int getMint() {
        return m_time_in_sec / 60;
    }

    public int getSec() {
        return m_time_in_sec % 60;
    }
}
