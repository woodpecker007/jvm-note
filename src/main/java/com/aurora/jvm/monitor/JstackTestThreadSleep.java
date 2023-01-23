package com.aurora.jvm.monitor;

public class JstackTestThreadSleep {
    public static void main(String[] args) {
        System.out.println("hello");
        try {
            Thread.sleep(60_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("world");
    }
}
