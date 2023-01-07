package com.aurora.jvm.stringg;

public class StringCreate {

    public static void main(String[] args) {
        String a = new String("a"); //创建2个对象
        String bc = new String("b")
                + new String("c"); //创建6个对象


        bc.intern();
        String ss = "bc";
        System.out.println(bc == ss);
    }
}
