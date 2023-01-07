package com.aurora.jvm.classloader;

public class MyLoader {

    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader extLoader = systemClassLoader.getParent();
        System.out.println(extLoader);

        ClassLoader bootstrapLoader = extLoader.getParent();
        System.out.println(bootstrapLoader);

    }
}
