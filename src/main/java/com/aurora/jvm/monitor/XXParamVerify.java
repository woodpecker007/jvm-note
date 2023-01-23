package com.aurora.jvm.monitor;

public class XXParamVerify {
    // XX:PrintCommandLineFlags
    public static void main(String[] args) {
        System.out.println("hel");
        try {
            Thread.sleep(1 * 60_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
