package com.aurora.jvm.classloader;

import sun.misc.Launcher;

import java.net.URL;

public class LoaderPath {
    public static void main(String[] args) {
        URL[] path = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : path) {
            System.out.println(url);
        }

        System.out.println("=========================");

        String dirs = System.getProperty("java.ext.dirs");
        for (String dir : dirs.split(":")) {
            System.out.println(dir);
        }

    }
}
