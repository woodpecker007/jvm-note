package com.aurora.jvm.monitor;

public class MonitorTest {
    public static void main(String[] args) {
        try {
            Thread.sleep(50 * 60_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
