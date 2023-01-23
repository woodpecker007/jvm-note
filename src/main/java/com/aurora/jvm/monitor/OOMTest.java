package com.aurora.jvm.monitor;

import java.util.ArrayList;

public class OOMTest {

    // 设置虚拟机运行参数 -Xm30m -Xmx30m -XX:SurvivorRatio=8
    // 发生OOM时生成dump文件 -XX:+HeapDumpOnOutOfMemoryError
    // -XX:HeapDumpPath=/Users/woodpecker/Documents/dump/cc.hprof
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            byte[] arr = new byte[1024 * 100];//100KB
            list.add(arr);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
