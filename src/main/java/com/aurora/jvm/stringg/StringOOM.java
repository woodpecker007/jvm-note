package com.aurora.jvm.stringg;

import java.util.HashSet;
import java.util.Set;

/**
 * vm options: -Xms2m -Xmx2m
 */
public class StringOOM {
    public static void main(String[] args) {
        //使用Set保持着常量池引用，避免full gc回收常量池行为
        Set<String> set = new HashSet<>();
        //在short可以取值的范围内足以让2MB的heap产生OOM了。
        short i = 0;
        while(true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
