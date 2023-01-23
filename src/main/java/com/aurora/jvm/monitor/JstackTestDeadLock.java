package com.aurora.jvm.monitor;

public class JstackTestDeadLock {
    private static String lockA = "锁对象A";
    private static String lockB = "锁对象B";

    public static void main(String[] args) {
        new Thread() {
            public void run() {
                while (true) {
                    synchronized (lockA) {
                        System.out.println(this.getName() + ":得到lockA");
                        synchronized (lockB) {
                            System.out.println(this.getName() + ":得到lockB");
                        }
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    synchronized (lockB) {
                        System.out.println(this.getName() + ":得到lockB");
                        synchronized (lockA) {
                            System.out.println(this.getName() + ":得到lockA");
                        }
                    }
                }
            }
        }.start();
    }
}
